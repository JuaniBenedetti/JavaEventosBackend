package eventos.eventos.web.usuario;

import eventos.eventos.model.Usuario;
import eventos.eventos.model.dto.UsuarioClienteDTO;
import eventos.eventos.services.cliente.ClienteService;
import eventos.eventos.services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController{

    private final UsuarioService usuarioService;

    private final ClienteService clienteService;

    @Override
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registrar(@RequestBody @Valid UsuarioClienteDTO usuarioClienteDTO) throws Exception {
        var usuario = usuarioService.registrar(usuarioClienteDTO.getUsuario());
        clienteService.save(usuarioClienteDTO.getCliente());
        return usuario;
    }

    @Override
    @PostMapping("/enable")
    public ResponseEntity<String> activarUsuario(@RequestParam String email, @RequestParam String codigo) throws Exception {
        return usuarioService.activarUsuario(email, codigo);
    }
}
