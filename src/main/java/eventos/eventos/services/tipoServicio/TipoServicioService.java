package eventos.eventos.services.tipoServicio;

import eventos.eventos.model.TipoServicio;

import java.util.List;

public interface TipoServicioService {

    TipoServicio findTipoServicio(Long idTipoServicio) throws Exception;

    TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception;

    TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception;

    void deleteTipoServicio(TipoServicio tipoServicio) throws Exception;

    List<TipoServicio> findAllTipoServicio() throws Exception;
}
