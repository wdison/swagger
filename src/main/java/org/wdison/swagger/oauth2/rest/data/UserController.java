/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wdison.swagger.oauth2.rest.data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wdison.swagger.oauth2.entity.UserEntity;

/**
 *
 * @author Jose Wdison de Souza <a>wdison@hotmail.com</a>
 */
@RepositoryRestResource(path = "/user", collectionResourceRel = "users")
//@Api(value = "Usuarios do sistema")
@Api(tags = "Usuarios do sistema")
public interface UserController extends PagingAndSortingRepository<UserEntity, Long> {
    @ApiOperation("pesquisa todos os usuarios compativeis com o nome enviado")
    List<UserEntity> findByName(@Param("name") String name);
}
