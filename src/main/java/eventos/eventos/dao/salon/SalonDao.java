package eventos.eventos.dao.salon;

import eventos.eventos.Model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalonDao extends JpaRepository<Salon, Long> {

    public Salon findSalonByDenominacion(String denominacion);


}
