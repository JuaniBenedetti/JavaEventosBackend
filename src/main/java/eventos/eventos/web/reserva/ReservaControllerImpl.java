package eventos.eventos.web.reserva;

import eventos.eventos.exceptions.ReservaException;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Reserva;
import eventos.eventos.model.Salon;
import eventos.eventos.model.enums.Rol;
import eventos.eventos.security.UserDetailsImpl;
import eventos.eventos.security.UserDetailsServiceImpl;
import eventos.eventos.services.cliente.ClienteService;
import eventos.eventos.services.reserva.ReservaService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/reserva")
public class ReservaControllerImpl extends CRUDControllerImpl<Reserva> implements ReservaController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ClienteService clienteService;

    private final ReservaService reservaService;

    public ReservaControllerImpl(ReservaService reservaService) {
        super(reservaService);
        this.reservaService = reservaService;
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody @Valid Reserva reserva) throws ReservaException {
        reserva.setCliente(clienteActual());
        reserva.setCostoTotal();
        return reservaService.save(reserva);
    }

    @Override
    @GetMapping("/findAll")
    public List<Reserva> findAll() {
        if (usuarioActual().getUsuario().getRoles().stream().anyMatch(rol -> rol.getNombre() == Rol.ROLE_OWNER))
            return reservaService.findAll();
        else {
            Cliente cliente = clienteActual();
            return reservaService.findAllByCliente(cliente);
        }
    }

    @Override
    @GetMapping("/findFechasReservadas")
    public Set<ZonedDateTime> findFechasReservadasByIdSalon(@RequestParam Long idSalon) {
        return reservaService.findFechasReservadasByIdSalon(idSalon);
    }

    private UserDetailsImpl usuarioActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl usuarioActual = userDetailsService.loadUserByUsername(authentication.getPrincipal().toString());
        return usuarioActual;
    }

    private Cliente clienteActual() {
        Cliente cliente = clienteService.findByUsuario(usuarioActual().getUsuario());
        return cliente;
    }
}
