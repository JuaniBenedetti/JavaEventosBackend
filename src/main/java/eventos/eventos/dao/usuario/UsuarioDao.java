package eventos.eventos.dao.usuario;

import eventos.eventos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByUsername(String username);

    Optional<Usuario> findOneByEmail(String email);

    Optional<Usuario> findOneByUsernameOrEmail(String username, String email);
}
