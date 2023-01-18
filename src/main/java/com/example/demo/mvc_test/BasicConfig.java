package com.example.demo.mvc_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class BasicConfig {

    @Bean
    CommandLineRunner clr(BasicRepository repo){
        return args -> {
            BasicObject bo1 = new BasicObject("test1");
            BasicObject bo2 = new BasicObject("test2");
            BasicObject bo3 = new BasicObject("test3");
            BasicObject bo4 = new BasicObject("test4");

            repo.saveAll(
                    List.of(bo1, bo2, bo3, bo4)
            );
        };
    }
    //@Bean
    public RouterFunction<ServerResponse> routerFunction(BasicHandler handler){
        return route()
                .GET("/{id}", accept(MediaType.APPLICATION_JSON), handler::getBasic)
                .DELETE("/{id}", accept(MediaType.APPLICATION_JSON), handler::deleteBasic)
                .build();
    }
}
