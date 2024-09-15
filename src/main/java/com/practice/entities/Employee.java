package com.practice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name", unique = true)
    private String fullName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Boolean marrie;

    public Employee() {
    }

    public Employee(Long id, String fullName, LocalDate birthDate, Boolean marrie) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.marrie = marrie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getMarrie() {
        return marrie;
    }

    public void setMarrie(Boolean marrie) {
        this.marrie = marrie;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", marrie=" + marrie +
                '}';
    }
}
