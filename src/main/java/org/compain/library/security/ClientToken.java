package org.compain.library.security;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;


public class ClientToken extends UsernamePasswordAuthenticationToken {

    @Getter
    private final Long userId;

    public ClientToken(Object principal, Long userId) {
        super(principal, null, new ArrayList<>());
        this.userId = userId;
    }

}
