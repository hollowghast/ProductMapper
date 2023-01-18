package com.example.demo.mvc_test;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

//S@Component
public class BasicHandler {
    public ServerResponse getBasic(ServerRequest req){
        //...
        return ServerResponse.ok().build();
    }

    public ServerResponse deleteBasic(ServerRequest req){
        //...
        return ServerResponse.ok().build();
    }
}
