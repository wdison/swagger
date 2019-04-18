package org.wdison.swagger.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter 
{

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                
//                .requestMatchers().antMatchers("/user***", "/swagger-ui***", "/v2/***", "/webjars/******", "/").per
//                .and()
                
                .authorizeRequests()
                    .antMatchers("/user***", "/swagger-ui***", "/v2/***", 
                            "/webjars/******", "/profile*", "/profile*/**"
                            , "/"
                            ,"/webjars/*/**"
                            ,"/swagger-resources**"
                            ,"/swagger-resources/*/**"
                            ,"/csrf**"
                    )
                    .permitAll()
                .and().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(new StatelessAuthenticationFilter(userAuthenticationService), UsernamePasswordAuthenticationFilter.class)
                ;

    }
    
}
