package eventos.eventos.dao.servicio;

import eventos.eventos.Model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicioDao extends JpaRepository<Servicio, Integer> {

    Servicio findById(int idServicio);

    Servicio findByDenominacion( String denominacion);
}
