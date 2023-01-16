package eventos.eventos.Web.salon;

import eventos.eventos.Model.Salon;

import java.util.List;

public interface SalonController {
    List<Salon> getSalones() throws Exception;

    Salon getSalon(long id) throws Exception;
}
