package eventos.eventos.services.cliente;

import eventos.eventos.model.Cliente;
import eventos.eventos.model.Usuario;
import eventos.eventos.services._CRUD.CRUDService;

import java.util.List;


public interface ClienteService extends CRUDService<Cliente> {

    Cliente findByUsuario(Usuario usuario);
}
