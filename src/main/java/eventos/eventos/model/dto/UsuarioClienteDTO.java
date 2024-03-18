package eventos.eventos.model.dto;

import eventos.eventos.model.Cliente;
import eventos.eventos.model.Usuario;
import lombok.Data;

@Data
public class UsuarioClienteDTO {
    Usuario usuario;
    Cliente cliente;
}
