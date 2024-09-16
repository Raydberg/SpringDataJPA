package com.practice.controller;

import com.practice.entities.Book;
import com.practice.entities.Employee;
import com.practice.repository.BookRepository;
import com.practice.repository.EmployeeRepository;
import jakarta.persistence.Embeddable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/employees")
@RestController
public class EmployeeControler {
    private final BookRepository bookRepository;
    private EmployeeRepository employeeRepo;

    public EmployeeControler(EmployeeRepository employeeRepo, BookRepository bookRepository) {
        this.employeeRepo = employeeRepo;
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public List<Employee> fillAdd() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee fillById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.get();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee result = employeeRepo.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee result = employeeRepo.save(employee);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        employeeRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
