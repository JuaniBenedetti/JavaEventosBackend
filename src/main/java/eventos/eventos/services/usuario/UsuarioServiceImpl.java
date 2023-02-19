package eventos.eventos.services.usuario;

import eventos.eventos.exceptions.UsuarioRegistradoException;
import eventos.eventos.model.Usuario;
import eventos.eventos.model.UsuarioVerificacion;
import eventos.eventos.services.sendgrid.SendGridService;
import eventos.eventos.services.usuarioVerificacion.UsuarioVerificacionService;
import eventos.eventos.dao.usuario.UsuarioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioVerificacionService usuarioVerificacionService;
    private final SendGridService sendGridService;

    @Override
    @Transactional
    public Usuario registrar(Usuario usuario) throws Exception {
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
        else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));

            UsuarioVerificacion usuarioVerificacion = usuarioVerificacionService.crearUsuarioVerificacion();
            usuarioVerificacion.setUsuario(usuario);

            try {
                usuarioVerificacionService.saveUsuarioVerificacion(usuarioVerificacion);
                sendGridService.sendVerificationMail(
                        usuario.getEmail(),
                        usuarioVerificacion.getCodigo()
                );
            } catch (Exception ex) { throw ex; }

            return usuarioDao.save(usuario);
        }
    }
}
