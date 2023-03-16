package eventos.eventos.services.usuarioVerificacion;

import eventos.eventos.dao.usuarioVerificacion.UsuarioVerificacionDao;
import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;
import eventos.eventos.services.sendgrid.SendGridService;
import eventos.eventos.system.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UsuarioVerificacionServiceImpl implements UsuarioVerificacionService {

    private final ConfigProperties configProperties;
    private final UsuarioVerificacionDao usuarioVerificacionDao;
    private final SendGridService sendGridService;

    @Override
    public UsuarioVerificacion saveUsuarioVerificacion(UsuarioVerificacion usuarioVerificacion) throws Exception {
        return usuarioVerificacionDao.save(usuarioVerificacion);
    }

    @Override
    public UsuarioVerificacion crearUsuarioVerificacion() {
        UsuarioVerificacion usuarioVerificacion = new UsuarioVerificacion(generarCodigo(), calcularExpiracion());
        return usuarioVerificacion;
    }

    @Override
    public Usuario activarUsuario(Usuario user, String codigo) throws Exception {
        UsuarioVerificacion usuarioVerificacion = usuarioVerificacionDao.findByUsuario(user)
                .orElseThrow(() -> new NoSuchElementException("No existe un código de verificación para el usuario."));
        if (ZonedDateTime.now().isBefore(usuarioVerificacion.getFechaHoraExpiracion()) &&
            usuarioVerificacion.getCodigo().equals(codigo)) {
            user.setActivo(true);
        }
        else {
            // Actualizo codigo y fechaHoraExpiracion del usuarioVerificacion.
            usuarioVerificacionDao.saveAndFlush(
                    UsuarioVerificacion.builder()
                        .idUsuarioVerificacion(usuarioVerificacion.getIdUsuarioVerificacion())
                        .codigo(generarCodigo())
                        .fechaHoraExpiracion(calcularExpiracion())
                        .usuario(user).build()
            );
            sendGridService.sendVerificationMail(user.getEmail(), usuarioVerificacion.getCodigo());
        }
        return user;
    }

    private ZonedDateTime calcularExpiracion() {
        return ZonedDateTime.now().plusMinutes(configProperties.getURC_EXPIRATION_MIN());
    }

    private String generarCodigo() {
        Random random = new Random();
        return String.format("%0" + 6 + "d", random.nextInt(1000000));
    }
}
