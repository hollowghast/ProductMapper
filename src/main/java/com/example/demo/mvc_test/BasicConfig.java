package com.example.demo.mvc_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
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
}
