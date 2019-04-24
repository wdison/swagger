/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.rest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose WdisonController de Souza <a>wdison@hotmail.com</a>
 */
@RestController
@RequestMapping("/wdison")
public class WdisonController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dinheiro() {
        return "Wdison ganhando dinheiro";
    }
}
