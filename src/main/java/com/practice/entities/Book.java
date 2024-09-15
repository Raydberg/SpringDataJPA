package com.practice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private Integer pages;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double price;
    private Boolean online;

    public Book() {
    }

    public Book(Long id, String name, String author, Integer pages, LocalDate releaseDate, Double price, Boolean online) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.releaseDate = releaseDate;
        this.price = price;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                ", online=" + online +
                '}';
    }
}
