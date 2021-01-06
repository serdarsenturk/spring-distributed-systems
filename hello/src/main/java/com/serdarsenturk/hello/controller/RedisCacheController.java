package com.serdarsenturk.hello.controller;

import com.serdarsenturk.hello.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cachedPage")
@RestController
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;
    private int counter = 0; // Counter, count to is provide us how many times redis responsed to request

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(counter == 5){           // Counter when is 5 it'll clean by redisCacheService
            redisCacheService.clearCache();
            counter = 0;
        }
        counter++;
        return redisCacheService.longRunningMethod();
    }
}
