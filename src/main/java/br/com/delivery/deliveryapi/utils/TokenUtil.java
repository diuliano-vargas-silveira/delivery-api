package br.com.delivery.deliveryapi.utils;

import br.com.delivery.deliveryapi.exceptions.NoTokenPresentException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenUtil {

    private static final String AUTHORIZATION_HEADER = "authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    @Value("${env.secrets.jwt-token}")
    private String KEY;

    public String getUserByLogin(Map<String, String> headers) throws NoTokenPresentException {
        String jwt = headers.get(AUTHORIZATION_HEADER);

        if (jwt.isEmpty() || jwt.isBlank()) {
            throw new NoTokenPresentException("Usuário não autorizado!");
        }

        String token = jwt.replace(BEARER_PREFIX, "");

        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
