package com.develcode.develfood.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.develcode.develfood.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("develfoood")
                    .withSubject(user.getUsername())
                    .withExpiresAt(expirationDate())
                    .withClaim("id", user.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating jwt token", exception);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusDays(5).toInstant(ZoneOffset.of("-03:00"));
    }

}
