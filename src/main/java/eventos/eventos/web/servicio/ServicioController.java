package eventos.eventos.Web.servicio;

import eventos.eventos.Model.Servicio;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ServicioController {

    Servicio saveTipoServicio(Servicio servicio) throws Exception;

    Servicio updateTipoServicio(Servicio servicio) throws Exception;

    Servicio findServicio(int idServicio) throws Exception;

    void deleteServicio(int id) throws Exception;

    List<Servicio> findAll() throws Exception;

}
