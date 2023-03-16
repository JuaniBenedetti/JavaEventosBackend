package eventos.eventos.services.usuarioVerificacion;

import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;

public interface UsuarioVerificacionService {

    UsuarioVerificacion saveUsuarioVerificacion(UsuarioVerificacion usuarioVerificacion) throws Exception;

    UsuarioVerificacion crearUsuarioVerificacion();

    Usuario activarUsuario(Usuario user, String codigo) throws Exception;
}
