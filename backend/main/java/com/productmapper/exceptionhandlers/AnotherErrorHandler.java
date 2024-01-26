package com.productmapper.exceptionhandlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class AnotherErrorHandler {
    @GetMapping
    public String handleError(){
        return "forward:/html/error/Other.html";
    }
}
