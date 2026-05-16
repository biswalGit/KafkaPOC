package com.pit.employeems.kafka.producer;

import com.pit.employeems.event.EmployeeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventProducer {

    @Autowired
    private KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

    public void publish(EmployeeEvent event) {
        kafkaTemplate.send("employee-events", event);
        System.out.println(
                "EVENT PUBLISHED -> "
                        + event.getEventType());
    }
}
