package org.compain.library.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.compain.library.consumer.UserRepository;
import org.compain.library.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class AuthenticationService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String secret;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, @Value("${jwt.secret}") String secret) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.secret = secret;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new ClientDetails(user.getEmail(), user.getPassword(), user.getIdUser());
    }

    public String signIn(String username, String password) {
        User user = userRepository.findByUsername(username)
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("bad credentials"));
        Map<String, Object> claims = new HashMap<>();
        //TODO:: constant to avoid this magic string
        claims.put("account_id", user.getIdUser());
        claims.put("role", user.getRole().getDesignation());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

}
