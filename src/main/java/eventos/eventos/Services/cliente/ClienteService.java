package eventos.eventos.Services.cliente;

import ch.qos.logback.core.net.server.Client;
import eventos.eventos.Model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface ClienteService {
    List<Cliente> findClientes() throws Exception;

    Cliente findCliente(long id) throws Exception;

    Cliente updateCliente(Cliente cliente) throws Exception;

    void deleteCliente(long id) throws Exception;

    Cliente newCliente(Cliente cliente) throws Exception;
}
