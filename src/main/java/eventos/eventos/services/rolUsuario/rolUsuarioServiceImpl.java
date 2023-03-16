package eventos.eventos.services.rolUsuario;

import eventos.eventos.dao.rolUsuario.RolUsuarioDao;
import eventos.eventos.model.RolUsuario;
import eventos.eventos.model.enums.Rol;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class rolUsuarioServiceImpl implements rolUsuarioService {

    private final RolUsuarioDao rolUsuarioDao;

    @Override
    @PostConstruct
    public void actualizarRolesBD() throws Exception {

        final Logger log = LoggerFactory.getLogger(rolUsuarioServiceImpl.class);

        for (Rol rol: Rol.values()) {
            if (!rolUsuarioDao.existsByNombre(rol)) {
                log.info("\u001B[38;2;255;255;255m" +
                        "\u001B[48;2;0;147;0m" +
                        "########## AGREGANDO ROL EN LA BASE DE DATOS ##########" +
                        "\u001B[0m"
                );
                RolUsuario rolUsuarioDB = new RolUsuario();
                rolUsuarioDB.setNombre(rol);
                rolUsuarioDao.save(rolUsuarioDB);
            }
        }

        try {
            rolUsuarioDao.findAll();
        } catch (InvalidDataAccessApiUsageException exception) {
            log.warn("\u001B[38;2;255;255;255m" +
                    "\u001B[48;2;252;127;0m" +
                    "########## ATENCION: EXISTEN REGISTROS DE ROLES QUE NO SE ENCUENTRAN EN EL ENUM LOCAL ##########" +
                    "\u001B[0m"
            );
        }
    }
}
