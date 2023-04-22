package eventos.eventos.dao.cliente;

import eventos.eventos.dao._CRUD.CRUDDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends CRUDDao<Cliente> {

    Cliente findByUsuario(Usuario usuario) throws Exception;
}
