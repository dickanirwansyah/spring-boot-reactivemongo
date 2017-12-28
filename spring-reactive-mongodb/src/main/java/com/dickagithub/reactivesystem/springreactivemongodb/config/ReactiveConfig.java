package com.dickagithub.reactivesystem.springreactivemongodb.config;

import com.dickagithub.reactivesystem.springreactivemongodb.router.RouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ReactiveConfig {

    //reactive router handlers
    //router diambil dari class RoutersHandlers

    @Bean
    RouterFunction<?> routerFunction(RouterHandlers routerHandlers) {

        return RouterFunctions.route(
                RequestPredicates
                        .GET("/resources/employees"),
                routerHandlers::getAll)
                .andRoute(RequestPredicates
                        .GET("/resources/employees/{id}"),
                        routerHandlers::getOne)
                .andRoute(RequestPredicates
                                .GET("/resources/employees/{id}/events"),
                        routerHandlers::getEvents);

    }
}
