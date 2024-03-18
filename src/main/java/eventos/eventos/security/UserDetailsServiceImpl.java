package eventos.eventos.security;

import eventos.eventos.dao.usuario.UsuarioDao;
import eventos.eventos.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioDao
                .findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con username " + username + " no existe."));

        return new UserDetailsImpl(user);
    }
}
