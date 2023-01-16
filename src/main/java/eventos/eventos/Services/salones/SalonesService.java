package eventos.eventos.Services.salones;

import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Salon;

import java.util.List;

public interface SalonesService {
    List<Salon> findSalones() throws Exception;

    Salon findSalonById(long id) throws Exception;

    Salon saveSalon(Salon salon) throws Exception;

    Salon updateSalon(Salon salon) throws Exception;

    void deleteById(long id) throws Exception;
}
