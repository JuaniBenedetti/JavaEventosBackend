package eventos.eventos.web.salon;

import eventos.eventos.model.Salon;
import eventos.eventos.security.UserDetailsImpl;
import eventos.eventos.security.UserDetailsServiceImpl;
import eventos.eventos.services.administrativo.AdministrativoService;
import eventos.eventos.services.salon.SalonService;
import eventos.eventos.web._CRUD.CRUDControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/salon")
public class SalonControllerImpl extends CRUDControllerImpl<Salon> implements SalonController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AdministrativoService administrativoService;

    private SalonService salonService;

    public SalonControllerImpl(SalonService salonService) {
        super(salonService);
        this.salonService = salonService;
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon save(@RequestBody @Valid Salon salon) throws Exception{
        salon.setPropietario(administrativoService.findByUsuario(usuarioActual().getUsuario()));
        return salonService.save(salon);
    }

    private UserDetailsImpl usuarioActual() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl usuarioActual = userDetailsService.loadUserByUsername(authentication.getPrincipal().toString());
        return usuarioActual;
    }
}

