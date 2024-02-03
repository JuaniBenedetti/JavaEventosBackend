package eventos.eventos.services.cliente;

import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.model.Usuario;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CRUDServiceImpl<Cliente> implements ClienteService{

    private final ClienteDao clienteDao;

    public ClienteServiceImpl(ClienteDao clienteDao) {
        super(clienteDao);
        this.clienteDao = clienteDao;
    }

    @Override
    public Cliente findByUsuario(Usuario usuario) throws Exception{
        return clienteDao.findByUsuario(usuario);
    }
}
