package com.example.demo.ui_tests;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(value = "/bye"/*, method = RequestMethod.GET*/)
public class HelloMVC {

    @GetMapping()
    public String hello_mvc(@RequestParam(value = "name", defaultValue = "World") String name, Model m){
        //m.addAttribute(new Hello(counter.incrementAndGet(), name, String.format(MESSAGE_TEMPLATE, name)));
        //m.addAttribute("id", counter.incrementAndGet());
        m.addAttribute("name", name);
        return "hello";
    }

}