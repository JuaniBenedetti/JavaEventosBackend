package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;

import java.util.List;

public interface TipoServicioService {

    TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception;

    TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception;

    TipoServicio findTipoServicio(int idTipoServicio) throws Exception;

    List<TipoServicio> findAll() throws Exception;

    void deleteTipoServicio(int id) throws Exception;
}
