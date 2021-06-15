package org.compain.library.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String secret;
    private final String prefix;

    public SecurityConfiguration(@Value("${jwt.secret}") String secret,
                                 @Value("${jwt.prefix}") String prefix) {
        this.secret = secret;
        this.prefix = prefix;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsFilter())
                .and()
                .csrf().disable().sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), secret, prefix))
                .exceptionHandling().accessDeniedHandler(this::forbiddenExceptionHandler)
                .and()
                .exceptionHandling().authenticationEntryPoint(this::unauthorizedExceptionHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/accueil").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }

    private CorsConfigurationSource corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    private void forbiddenExceptionHandler(HttpServletRequest request,
                                           HttpServletResponse response,
                                           AccessDeniedException exception) throws IOException {
        createErrorMessage(FORBIDDEN, response, exception);
    }

    private void unauthorizedExceptionHandler(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException exception) throws IOException {
        createErrorMessage(UNAUTHORIZED, response, exception);
    }

    private void createErrorMessage(HttpStatus status,
                                    HttpServletResponse response,
                                    Exception exception)
            throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(exception.getMessage());
    }

}
