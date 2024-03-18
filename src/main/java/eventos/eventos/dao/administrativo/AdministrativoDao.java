package eventos.eventos.dao.administrativo;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.model.Administrativo;
import eventos.eventos.model.Usuario;

public interface AdministrativoDao extends CRUDDao<Administrativo> {

    Administrativo findByUsuario(Usuario usuario);
}
