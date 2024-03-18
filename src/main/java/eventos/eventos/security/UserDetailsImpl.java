package eventos.eventos.security;

import eventos.eventos.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Usuario usuario;

    public Usuario getUsuario() { return this.usuario; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre().name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { return usuario.getActivo(); }
}
