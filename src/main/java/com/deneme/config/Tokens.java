package com.deneme.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Tokens {
    @PostConstruct
<<<<<<< HEAD
    public void init() {
        System.out.println("Init Metot PostConstruct : ");
=======
    public void init() throws Exception {
        System.out.println("Inıt Metot PostConstruct : ");
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    public Map<Object, Object> getTokensMap() {
        return tokensMap;
    }

    private Map<Object,Object> tokensMap= new HashMap<Object,Object>(); //Key token - value userId

}
