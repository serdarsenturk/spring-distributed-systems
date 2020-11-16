package com.serdarsenturk.hello.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache") // I set my cache name and Cacheable annotation make my cache this variable
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000);
        return "Method Worked";
    }

    @CacheEvict(cacheNames = "mySpecialCache") // CacheEvict will clear my cache where defined by CacheNames
    public void clearCache(){
        System.out.println("Cache was cleaned");
    }
}
