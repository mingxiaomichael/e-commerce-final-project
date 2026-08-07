package com.ecommerce.account.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String userEmail = null;
        String jwt = null;

        // Check if the Authorization header is present and starts with "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);  // Extract the token after "Bearer "
            userEmail = jwtUtil.extractUserEmail(jwt);  // Parse the token to get the email
        }

        // Check if userEmail is extracted and no authentication is set in the context
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Validate token and set the authentication
            if (jwtUtil.validateToken(jwt)) {  // Implement validateToken in JwtUtil for token validation
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userEmail, null, new ArrayList<>());  // You can set roles here if needed
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);  // Continue with the filter chain
    }
}
