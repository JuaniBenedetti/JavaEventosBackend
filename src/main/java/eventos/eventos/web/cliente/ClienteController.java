package eventos.eventos.Web.cliente;

import eventos.eventos.Model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ClienteController {
    List<Cliente> getClientes() throws Exception;

    Cliente getCliente(long id) throws Exception;

    Cliente updateCliente(Cliente cliente ) throws Exception;

    void deleteCliente(long id)throws Exception;

    Cliente newCliente(Cliente cliente) throws  Exception;
}
