package eventos.eventos.services.cliente;

import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.model.Cliente;
import eventos.eventos.services._CRUD.CRUDServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl extends CRUDServiceImpl<Cliente> implements ClienteService{

    public ClienteServiceImpl(ClienteDao clienteDao) { super(clienteDao); }
}
