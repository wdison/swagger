/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {

private final UserAuthenticationService authenticationService;

	public StatelessAuthenticationFilter(UserAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws
			IOException,
			ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Authentication authentication = authenticationService.getAuthentication(httpRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
		SecurityContextHolder.getContext().setAuthentication(null);
	}
    
}
