package com.practice;

import com.practice.entities.Employee;
import com.practice.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(App.class, args);
      var employeeRepo =  context.getBean(EmployeeRepository.class);
        List<Employee> employees = List.of(
                new Employee(null,"Prueba JPA1", LocalDate.now(),true),
                new Employee(null,"Prueba JPA2", LocalDate.now(),false),
                new Employee(null,"Prueba JPA3", LocalDate.now(),true),
                new Employee(null,"Prueba JPA4", LocalDate.now(),false),
                new Employee(null,"Prueba JPA5", LocalDate.now(),true),
                new Employee(null,"Prueba JPA6", LocalDate.now(),false),
                new Employee(null,"Prueba JPA7", LocalDate.now(),true),
                new Employee(null,"Prueba JPA8", LocalDate.now(),false),
                new Employee(null,"Prueba JPA9", LocalDate.now(),true)
        );
        employeeRepo.saveAll(employees);
        employeeRepo.findAllByMarrieTrue().forEach(System.out::println);
    }

}
