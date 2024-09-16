package com.practice;

import com.practice.entities.Book;
import com.practice.entities.Employee;
import com.practice.repository.BookRepository;
import com.practice.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var bookRepo = context.getBean(BookRepository.class);
        var employeeRepo = context.getBean(EmployeeRepository.class);
        List<Book> books = List.of(
                new Book(null, "Libro 1", "Ryan", 10, LocalDate.of(1999, 4, 12), 20.99, false),
                new Book(null, "Libro 2", "Mario", 20, LocalDate.of(2005, 7, 18), 99.99, true),
                new Book(null, "Libro 3", "Rocio", 110, LocalDate.now(), 12.8, false),
                new Book(null, "Libro 4", "Pedro", 30, LocalDate.of(1997, 2, 20), 12.97, true),
                new Book(null, "Libro 5", "Marcos", 146, LocalDate.of(2000, 6, 19), 28.9, false),
                new Book(null, "Libro 6", "Lucas", 123, LocalDate.now(), 12.8, true),
                new Book(null, "Libro 7", "Bryan", 53, LocalDate.of(2009, 8, 21), 78.9, false),
                new Book(null, "Libro 8", "Lourdes", 56, LocalDate.of(2023, 5, 29), 89.9, true),
                new Book(null, "Libro 9", "Roger", 87, LocalDate.of(1996, 9, 8), 89.17, false),
                new Book(null, "Libro 10", "Wilmer", 109, LocalDate.now(), 12.8, true)
        );
        bookRepo.saveAll(books);
        List<Employee> employees = List.of(
                new Employee(null,"Employee1","Apellido1",12),
                new Employee(null,"Employee2","Apellido2",20),
                new Employee(null,"Employee3","Apellido3",23),
                new Employee(null,"Employee4","Apellido4",54),
                new Employee(null,"Employee5","Apellido5",65)
        );
        employeeRepo.saveAll(employees);
    }
@Configuration
	public static class Myconfiguration{
		@Bean
		public WebMvcConfigurer corsConfigurer(){
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
				}
			};
		}
	}
}
