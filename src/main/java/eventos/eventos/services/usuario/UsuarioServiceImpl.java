package eventos.eventos.services.usuario;

import eventos.eventos.dao.usuario.UsuarioDao;
import eventos.eventos.exceptions.UsuarioAlteradoException;
import eventos.eventos.exceptions.UsuarioRegistradoException;
import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;
import eventos.eventos.services.sendgrid.SendGridService;
import eventos.eventos.services.usuarioVerificacion.UsuarioVerificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioVerificacionService usuarioVerificacionService;
    private final SendGridService sendGridService;

    @Override
    @Transactional
    public Usuario registrar(Usuario usuario) throws Exception {
            validarUsuario(usuario);

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));

            UsuarioVerificacion usuarioVerificacion = usuarioVerificacionService.crearUsuarioVerificacion();
            usuarioVerificacion.setUsuario(usuario);

            usuarioVerificacionService.saveUsuarioVerificacion(usuarioVerificacion);
            sendGridService.sendVerificationMail(usuario.getEmail(), usuarioVerificacion.getCodigo());

            // No hago el save() porque lo realiza usuarioVerificacion (cascade = CascadeType.PERSIST).
            return usuario;
    }

    @Override
    public ResponseEntity<String> activarUsuario(String email, String codigo) throws Exception {
        Usuario user = usuarioDao.findOneByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("No existe usuario registrado con el email ingresado."));
        if (usuarioVerificacionService.activarUsuario(user, codigo).getActivo()) {
            usuarioDao.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity
                .badRequest()
                .body("El código ingresado no es válido o ha expirado.");
    }

    private void validarUsuario(Usuario usuario) throws Exception {
        // Valido que sólo se reciba username, password y email.
        if (usuario.getActivo() || !usuario.getRoles().isEmpty() || usuario.getIdUsuario() != null) {
            throw new UsuarioAlteradoException("El usuario a registrar viola las restricciones de seguridad.");
        }

        // Verifico que el usuario no esté registrado.
        Usuario usuarioDB = usuarioDao.findOneByUsernameOrEmail(usuario.getUsername(), usuario.getEmail()).orElse(null);
        if (usuarioDB != null) {
            if (usuarioDB.getEmail().equals(usuario.getEmail())) {
                if (usuarioDB.getActivo()) {
                    throw new UsuarioRegistradoException("Existe una cuenta activa con el mail ingresado.");
                }
                else {
                    throw new UsuarioRegistradoException("Existe una cuenta pendiente de activación con el mail ingresado.");
                }
            }
            else { throw new UsuarioRegistradoException("El nombre de usuario ya ha sido utilizado."); }
        }
    }
}
