package eventos.eventos.web.usuario;


import eventos.eventos.model.Usuario;
import eventos.eventos.model.dto.UsuarioClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface UsuarioController {

    Usuario registrar(UsuarioClienteDTO usuarioClienteDTO) throws Exception;

    ResponseEntity<String> activarUsuario(String email, String codigo) throws Exception;
}
