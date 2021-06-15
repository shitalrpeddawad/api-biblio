package org.compain.library.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.vavr.control.Try;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


public class JwtAuthenticationFilter extends BasicAuthenticationFilter{

    private final String secret;
    private final String prefix;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String secret, String prefix) {
        super(authenticationManager);
        this.secret = secret;
        this.prefix = prefix;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(h -> h.startsWith(this.prefix))
                .map(h -> h.substring(this.prefix.length() + 1))
                .ifPresent(t -> Try.of(() -> authenticate(t))
                        .onSuccess(a -> SecurityContextHolder.getContext().setAuthentication(a))
                        .onFailure(e -> SecurityContextHolder.clearContext()));

        chain.doFilter(request, response);
    }

    private ClientToken authenticate(String token) {
        final Claims claims = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody();
        Long accountId = Long.parseLong(claims.get("account_id").toString());
        return new ClientToken(claims.getSubject(), accountId);
    }

}
