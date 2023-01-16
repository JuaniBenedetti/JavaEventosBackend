package eventos.eventos.dao.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicioDao extends JpaRepository<TipoServicio, Integer> {

    TipoServicio findById(int idTipoServicio);
}
