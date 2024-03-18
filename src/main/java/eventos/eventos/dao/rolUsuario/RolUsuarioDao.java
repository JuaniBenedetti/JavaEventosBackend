package eventos.eventos.dao.rolUsuario;

import eventos.eventos.model.RolUsuario;
import eventos.eventos.model.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioDao extends JpaRepository<RolUsuario, Long> {
    Boolean existsByNombre(Rol rol);
}
