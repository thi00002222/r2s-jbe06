package com.example.demo.security;

import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final SecretKey secretKey;

    @Value("${app.jwt.expiration-seconds}")
    private long expirationSeconds;

    @Value("${app.jwt.issuer}")
    private String issuer;

    public JwtService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(expirationSeconds);

        List<String> roles = user.getRoles().stream()
                .map(role -> "ROLE_" + role.getRoleName())
                .toList();

        Set<String> authorities =
                Optional.ofNullable(user.getRoles())
                        .orElse(Collections.emptySet())
                        .stream()
                        .flatMap(role ->
                                Optional.ofNullable(role.getAuthorities())
                                        .orElse(Collections.emptySet())
                                        .stream()
                        )
                        .map(Authority::getAuthorityName)
                        .collect(Collectors.toSet());

        return Jwts.builder()
                .setIssuer(issuer)
                .setSubject(user.getUsername())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .claim("roles", roles)
                .claim("authorities", authorities)
                .signWith(secretKey)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }
}
