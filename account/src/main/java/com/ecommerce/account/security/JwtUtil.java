package com.ecommerce.account.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey key= Keys.hmacShaKeyFor("Your-Very-Secure-32-Character-Key".getBytes());

    // Generate JWT Token
    public String generateToken(String userEmail, Long userId) {
        return Jwts.builder()
                .setSubject(userEmail)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 604800000)) // 7 days in milliseconds
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract user email from JWT Token
    public String extractUserEmail(String token) {
        return getClaims(token).getSubject();
    }

    // extract userId
    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
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

    // Get Claims
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
