package com.pit.employeems.service;

import com.pit.employeems.dbroute.DataSourceContextHolder;
import com.pit.employeems.dto.Employee;
import com.pit.employeems.event.EmployeeEvent;
import com.pit.employeems.kafka.producer.EmployeeEventProducer;
import com.pit.employeems.repository.EmployeeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeEventProducer producer;


    @Transactional(readOnly = true)
    public List<Employee> getAll() {

        DataSourceContextHolder.set("REPLICA");

        return repository.findAll();
    }


    @Transactional
    public Employee save(Employee employee) {
        DataSourceContextHolder.set("PRIMARY");
        Employee saved = repository.save(employee);

        EmployeeEvent event = new EmployeeEvent();
        event.setEmployeeId(saved.getId());
        event.setName(saved.getName());
        event.setEventType("EMPLOYEE_CREATED");

        producer.publish(event);

        return saved;
    }

    @Cacheable(value = "employees", key = "#id")
    public Employee getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @CacheEvict(value = "employees", key = "#employee.id")
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

}
