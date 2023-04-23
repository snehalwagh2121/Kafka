package com.example.kafka.kafkademo.controller;

import com.example.kafka.kafkademo.model.Employee;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
    @Autowired
    KafkaTemplate<String, Employee> producer;
    @GetMapping("/produceMsg")
    public boolean sendEmployee() {
        Employee e = Employee.builder()
                .eId(1)
                .eName("Snehal")
                .dept("Devops")
                .build();
        producer.send("test", e);
        return true;
    }
}
