package com.serdarsenturk.hello.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.serdarsenturk.hello.publisher.Publisher;

@RestController
public class HelloWorldController {

    @Autowired
    Publisher publisher;
    @RequestMapping("/hello/send")
    public String sendMessage(@RequestParam("id") int id){
        System.out.println(id);
            publisher.produce(id);
        return "Valid request";
    }
}
