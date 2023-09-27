package org.softuni.mvcfn.config;

import org.softuni.mvcfn.web.TestHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class RoutsConfig {

    @Bean
    public RouterFunction<ServerResponse> routingFunction(TestHandlers testHandlers){

    return route().
            GET("/test", testHandlers::test)
            .build();

    }


}
