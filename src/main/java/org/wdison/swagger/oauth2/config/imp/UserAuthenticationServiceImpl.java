/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.config.imp;

import com.google.common.base.Strings;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.wdison.swagger.oauth2.config.UserAuthenticationService;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    public final String HEADER_AUTHORIZATION = "Authorization";
    public final String BEARER_AUTHENTICATION = "Bearer";
    public final String WHITESPACE = " ";

    @Override
    public Authentication getAuthentication(HttpServletRequest httpRequest) {
        UserAuthenticationToken userAuthenticationToken = null;
        String authenticationHeader = httpRequest.getHeader(HEADER_AUTHORIZATION);
        
        String acessToken = extrairAccessTokenDoHeader(authenticationHeader);
        if(!StringUtils.isEmpty(acessToken)){
            userAuthenticationToken = new UserAuthenticationToken(acessToken);
            //TODO pesquisar token no banco de dados ou em uma api de tokens
            userAuthenticationToken.setAuthenticated(acessToken.equals("wdison"));
        }
        
        return userAuthenticationToken;
    }

    private String extrairAccessTokenDoHeader(String authenticationHeader) {
        if (Strings.isNullOrEmpty(authenticationHeader)) {
//            throw new TokenException(TokenException.Type.NAO_AUTORIZADO);
            return null;
        }

        String[] valoresHeader = authenticationHeader.split(WHITESPACE);

        if (valoresHeader.length != 2) {
//            throw new TokenException(TokenException.Type.INVALIDO);
            return null;
        }

        if (!valoresHeader[0].equalsIgnoreCase(BEARER_AUTHENTICATION)) {
//            throw new TokenException(TokenException.Type.INVALIDO);
            return null;
        }

        if (Strings.isNullOrEmpty(valoresHeader[1])) {
//            throw new TokenException(TokenException.Type.INVALIDO);
            return null;
        }

        return valoresHeader[1];
    }
}
