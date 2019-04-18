/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */

public interface UserAuthenticationService {
    Authentication getAuthentication(HttpServletRequest httpRequest);
}
