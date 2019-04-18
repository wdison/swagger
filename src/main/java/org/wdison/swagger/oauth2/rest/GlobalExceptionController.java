/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.rest;

import java.util.Date;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wdison.swagger.oauth2.config.imp.TokenException;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ResponseBody
    @ExceptionHandler(TokenException.class)
    public ResponseEntity<ErrorInfo> handleAutenticacaoRBACException(TokenException ex) {
        ErrorInfo errorInfo = new ErrorInfo(ex, HttpStatus.UNAUTHORIZED);
        return generateResponseErrorInfo(errorInfo, HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<ErrorInfo> generateResponseErrorInfo(ErrorInfo errorInfo, HttpStatus httpStatus) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.clear();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        ResponseEntity<ErrorInfo> response = new ResponseEntity<>(errorInfo, httpHeaders, httpStatus);

        return response;
    }
    
    public static class ErrorInfo{
        public final String userMessage;
	public int status;
        //TODO aolicar a data abaixo
//	public final String date;

	public ErrorInfo(TokenException sivesException, HttpStatus status) {
		this.userMessage = sivesException.getMessage();
		this.status = status.value();
	}

	public String getUserMessage() {
		return userMessage;
	}

	public int getStatus() {
		return status;
	}
    }
}
