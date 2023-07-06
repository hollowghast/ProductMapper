package com.productmapper.ui_tests;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {
    private static final String MESSAGE_TEMPLATE =
            "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Hello(counter.incrementAndGet(), name, String.format(MESSAGE_TEMPLATE, name));
    }


}
