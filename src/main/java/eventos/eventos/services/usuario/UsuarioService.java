package eventos.eventos.services.usuario;

import eventos.eventos.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    Usuario registrar(Usuario usuario) throws Exception;

    ResponseEntity<String> activarUsuario(String email, String codigo) throws Exception;
}
