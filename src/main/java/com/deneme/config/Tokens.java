package com.deneme.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Tokens {
    @PostConstruct
    public void init() {
        System.out.println("Init Metot PostConstruct");
    }
    private final Map<Object,Object> tokensMap= new HashMap<>(); //Key token - value userId

    public Map<Object, Object> getTokensMap() {
        return tokensMap;
    }



}
