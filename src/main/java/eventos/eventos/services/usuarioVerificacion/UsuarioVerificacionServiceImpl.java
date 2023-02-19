package eventos.eventos.services.usuarioVerificacion;

import eventos.eventos.model.UsuarioVerificacion;
import eventos.eventos.dao.usuarioVerificacion.UsuarioVerificacionDao;
import eventos.eventos.system.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UsuarioVerificacionServiceImpl implements UsuarioVerificacionService {

    private final ConfigProperties configProperties;
    private final UsuarioVerificacionDao usuarioVerificacionDao;

    @Override
    public UsuarioVerificacion saveUsuarioVerificacion(UsuarioVerificacion usuarioVerificacion) throws Exception {
        return usuarioVerificacionDao.save(usuarioVerificacion);
    }

    @Override
    public UsuarioVerificacion crearUsuarioVerificacion() throws Exception {
        UsuarioVerificacion usuarioVerificacion = new UsuarioVerificacion(generarCodigo(), calcularExpiracion());
        return usuarioVerificacion;
    }

    private ZonedDateTime calcularExpiracion() {
        return ZonedDateTime.now().plusMinutes(configProperties.getURC_EXPIRATION_MIN());
    }

    private String generarCodigo() {
        Random random = new Random();
        return String.format("%0" + 6 + "d", random.nextInt(1000000));
    }
}
