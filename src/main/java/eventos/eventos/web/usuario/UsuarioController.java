package eventos.eventos.web.usuario;


import eventos.eventos.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UsuarioController {

    Usuario registrar(Usuario usuario) throws Exception;

    ResponseEntity<String> activarUsuario(Map<String, String> datosActivacion) throws Exception;
}
