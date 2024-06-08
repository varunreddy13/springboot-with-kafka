package com.example.springboot_with_kafka.controller;

import com.example.springboot_with_kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

@RestController
public class kafkaController {

    @Autowired
    MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message){
        messageProducer.sendMessage("my-topic",message);
        return "the message is : " +message;
    }
}
