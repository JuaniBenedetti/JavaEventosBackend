package eventos.eventos.security;

import eventos.eventos.model.RolUsuario;
import eventos.eventos.model.enums.Rol;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "$2a$12$pdDepYJQHDdnDqtwXlVmQeyo0uu9v8mLLzzx/Vadz..QBZfOCm2sG";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 3_600L;

    public static String createToken(UserDetailsImpl user) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Set<String> roles = user.getUsuario().getRoles().stream()
                .map(rolUsuario -> rolUsuario.getNombre().name())
                .collect(Collectors.toSet());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(expirationDate)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS512, ACCESS_TOKEN_SECRET.getBytes())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();

            ArrayList<String> roles = (ArrayList<String>) claims.get("roles");

            Set<GrantedAuthority> authorities = roles.stream()
                    .map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                    .collect(Collectors.toSet());

            return new UsernamePasswordAuthenticationToken(username, null, authorities);
        }
        catch (JwtException e) {
            return null;
        }
    }
}
