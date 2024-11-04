package com.ecommerce.account.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Generate a strong SecretKey for HS256 algorithm
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Generate JWT Token
    public String generateToken(String userEmail) {
        return Jwts.builder()
                .setSubject(userEmail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 604800000)) // 7 days in milliseconds
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract user email from JWT Token
    public String extractUserEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validate the JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
