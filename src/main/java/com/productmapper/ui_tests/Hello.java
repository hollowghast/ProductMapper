package com.productmapper.ui_tests;

import org.springframework.context.annotation.Bean;

public class Hello {
    private final long id;
    private final String name;
    private final String content;

    public Hello(long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
