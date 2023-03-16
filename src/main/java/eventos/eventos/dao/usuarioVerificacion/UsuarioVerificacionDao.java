package eventos.eventos.dao.usuarioVerificacion;

import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioVerificacionDao extends JpaRepository<UsuarioVerificacion, Long> {

    Optional<UsuarioVerificacion> findByUsuario(Usuario user);
}
