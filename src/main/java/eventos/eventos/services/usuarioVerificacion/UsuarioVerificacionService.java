package eventos.eventos.services.usuarioVerificacion;

import eventos.eventos.exceptions.UsuarioVerificacionException;
import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;

public interface UsuarioVerificacionService {

    UsuarioVerificacion saveUsuarioVerificacion(UsuarioVerificacion usuarioVerificacion);

    UsuarioVerificacion crearUsuarioVerificacion();

    Usuario activarUsuario(Usuario user, String codigo) throws Exception;
}
