package eventos.eventos.services.salon;

import eventos.eventos.model.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> findSalones() throws Exception;

    Salon findSalonById(long id) throws Exception;

    Salon saveSalon(Salon salon) throws Exception;

    Salon updateSalon(Salon salon) throws Exception;

    void deleteById(long id) throws Exception;
}
