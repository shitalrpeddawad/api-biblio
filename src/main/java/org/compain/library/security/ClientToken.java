package org.compain.library.security;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public class ClientToken extends UsernamePasswordAuthenticationToken {

    @Getter
    private final Long userId;

    public ClientToken(Object principal, Long userId, List<GrantedAuthority> authorities) {
        super(principal, null, authorities);
        this.userId = userId;
    }

}
