/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.config.imp;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
public class TokenException extends RuntimeException {
    
    public TokenException(Type type) {
        super(type.getMsg());
    }
    
    public static enum Type {
        NAO_AUTORIZADO("Não Autorizado!")
        , INVALIDO("Invalido");
        private String msg;
        private Type(String msg){
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
