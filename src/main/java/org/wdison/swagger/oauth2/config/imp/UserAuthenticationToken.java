/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.config.imp;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
class UserAuthenticationToken implements Authentication {

    private final String acessToken;
    private Boolean autenticado = true;

    String accessToken;

    public UserAuthenticationToken(String acessToken) {
        this.acessToken = acessToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return this.autenticado;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated)
            throws
            IllegalArgumentException {
        this.autenticado = isAuthenticated;

    }

    @Override
    public String getName() {
        return null;
    }

    public String getAcessToken() {
        return this.acessToken;
    }
}
