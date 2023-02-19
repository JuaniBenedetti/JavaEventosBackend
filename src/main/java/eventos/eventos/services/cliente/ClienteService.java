package eventos.eventos.services.cliente;

import eventos.eventos.model.Cliente;

import java.util.List;


public interface ClienteService {
    List<Cliente> findClientes() throws Exception;

    Cliente findCliente(long id) throws Exception;

    Cliente updateCliente(Cliente cliente) throws Exception;

    void deleteCliente(long id) throws Exception;

    Cliente newCliente(Cliente cliente) throws Exception;
}
