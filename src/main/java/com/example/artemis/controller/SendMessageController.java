package com.example.artemis.controller;

import com.example.artemis.config.JmsConfig;
import com.example.artemis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("/send")
    public void sendMessage(){
        Student s = new Student("MIKE");
        this.jmsTemplate.convertAndSend(JmsConfig.QUEUE, s);
    }
}
