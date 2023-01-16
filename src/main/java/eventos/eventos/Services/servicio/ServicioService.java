package eventos.eventos.Services.servicio;

import eventos.eventos.Model.Servicio;

import java.util.List;

public interface ServicioService {

    Servicio saveServicio(Servicio servicio) throws Exception;

    Servicio updateServicio(Servicio servicio) throws Exception;

    Servicio findServicio(int idServicio) throws Exception;

    List<Servicio> findAll() throws Exception;

    void deleteServicio(int id) throws Exception;
}
