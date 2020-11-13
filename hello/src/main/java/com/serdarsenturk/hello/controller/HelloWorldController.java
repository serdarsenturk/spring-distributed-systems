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
    public String sendMessage(@RequestParam("message") String message){
        System.out.println(message);
        publisher.produce(message);

        return "Successfully Message Sent";
    }
    @RequestMapping("/hello/cache")
    public String sendMessage(@RequestParam("id") Integer id){
        return "Successfully Message Sent";
    }
}
