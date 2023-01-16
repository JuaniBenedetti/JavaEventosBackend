package eventos.eventos.Web.tipoServicio;

import eventos.eventos.Model.TipoServicio;

import java.util.List;

public interface TipoServicioController {

    TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception;

    TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception;

    TipoServicio findTipoServicio(int idTipoServicio) throws Exception;

    List<TipoServicio> findAll() throws Exception;

    void deleteTipoServicio(int id) throws Exception;
}
