package eventos.eventos.services.administrativo;

import eventos.eventos.model.Administrativo;
import eventos.eventos.model.Usuario;
import eventos.eventos.services._CRUD.CRUDService;

public interface AdministrativoService extends CRUDService<Administrativo> {

    Administrativo findByUsuario(Usuario usuario) throws Exception;
}
