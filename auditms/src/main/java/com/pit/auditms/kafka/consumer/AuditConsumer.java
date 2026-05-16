package com.pit.auditms.kafka.consumer;

import com.pit.auditms.event.EmployeeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditConsumer {

    @KafkaListener(
            topics = "employee-events",
            groupId = "audit-group")
    public void consume(EmployeeEvent event) {

        System.out.println(
                "AUDIT EVENT -> "
                        + event.getEventType());
    }
}
