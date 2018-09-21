package com.fluently.blog.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUUID {
    public String createUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
