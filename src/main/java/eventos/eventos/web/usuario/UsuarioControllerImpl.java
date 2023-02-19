package eventos.eventos.Web.usuario;

import eventos.eventos.Model.Usuario;
import eventos.eventos.Services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
