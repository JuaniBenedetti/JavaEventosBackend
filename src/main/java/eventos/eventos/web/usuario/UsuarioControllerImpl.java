package eventos.eventos.web.usuario;

import eventos.eventos.model.Usuario;
import eventos.eventos.services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController{

    private final UsuarioService usuarioService;

    @Override
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registrar(@RequestBody @Valid Usuario usuario) throws Exception {
        return usuarioService.registrar(usuario);
    }

    @Override
    @PostMapping("/enable")
    public ResponseEntity<String> activarUsuario(@RequestBody Map<String, String> datosActivacion) throws Exception {
        String email = datosActivacion.get("email");
        String codigo = datosActivacion.get("codigo");
        return usuarioService.activarUsuario(email, codigo);
    }
}
