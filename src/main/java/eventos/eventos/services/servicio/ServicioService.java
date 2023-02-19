package eventos.eventos.services.servicio;

import eventos.eventos.model.Servicio;

import java.util.List;

public interface ServicioService {

    Servicio findServicio(Long idServicio) throws Exception;

    Servicio saveServicio(Servicio servicio) throws Exception;

    Servicio updateServicio(Servicio servicio) throws Exception;

    void deleteServicio(Servicio servicio) throws Exception;

    List<Servicio> findAllServicio() throws Exception;
}
