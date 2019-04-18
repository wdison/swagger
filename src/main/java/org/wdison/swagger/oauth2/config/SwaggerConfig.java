package org.wdison.swagger.oauth2.config;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.data.rest.schema.SpringDataRestSchemaExtensions;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({SpringDataRestConfiguration.class})
public class SwaggerConfig {

    @Bean
    public Docket api() {
        SpringDataRestSchemaExtensions a;
        
        return new Docket(DocumentationType.SPRING_WEB)
                .groupName("wdison-group")
                /*auth*/.securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.wdison"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title("Creative API")
                .description("Serviço Web para integrar Ferramentas de criatividade")
                .version("1.0.1")
                .contact(new Contact("Wdison API", "wdison.com", "contact@wdison.com"))
                .license("Lecença de coódigo aberto")
                .licenseUrl("wdi.com/licença")
                .termsOfServiceUrl("wdi.com/termsOfServiceUrl")
                .termsOfServiceUrl("wdi.com/termsOfServiceUrl")
                ;
        return builder.build();
    }

    /*auth*/
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    /*auth*/
    @Bean
    public SecurityConfiguration securityInfo() {
        return SecurityConfigurationBuilder.builder()
                .appName("Token para Wdison APP, Authorization (Ex: Bearer sdfwsw54fwefw5)")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("/*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "acess all");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(SecurityReference.builder().reference("Authorization").scopes(authorizationScopes).build());
    }
}
