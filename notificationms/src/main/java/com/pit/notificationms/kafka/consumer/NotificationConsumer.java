package com.pit.notificationms.kafka.consumer;

import com.pit.notificationms.event.EmployeeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "employee-events",
            groupId = "notification-group")
    public void consume(EmployeeEvent event) {

        System.out.println(
                "Notification Sent for employee: "
                        + event.getName());
    }
}
