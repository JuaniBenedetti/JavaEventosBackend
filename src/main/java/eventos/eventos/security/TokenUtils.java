package eventos.eventos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Date;

public class TokenUtils {

    //TODO UBICAR EN PROPERTIES Y CAMBIAR VALIDITY
    private final static String ACCESS_TOKEN_SECRET = "pruebaCAMBIAR";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(UserDetails user) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(expirationDate)
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

            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        }
        catch (JwtException e) {
            return null;
        }
    }
}
