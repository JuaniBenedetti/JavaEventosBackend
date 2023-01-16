package eventos.eventos.Services.cliente;

import eventos.eventos.Model.Cliente;
import eventos.eventos.dao.cliente.ClienteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService{

    private final ClienteDao clienteDao;

    @Override
    public List<Cliente> findClientes() throws Exception {
        return clienteDao.findAll();
    }
    @Override
    public Cliente findCliente(long id) throws Exception{
        return clienteDao.findById(id).get();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) throws Exception{
        return clienteDao.save(cliente);
    }

    @Override
    public void deleteCliente(long id) throws Exception{
        clienteDao.deleteById(id);
    }
    @Override
    public Cliente newCliente(Cliente cliente ) throws Exception{
       return clienteDao.save(cliente);
    }
}
