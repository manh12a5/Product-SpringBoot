package com.codegym.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String description;

    private Date dateTime;

    private int quantity;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, int price, String description, Date dateTime, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.category = category;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category= category;
    }
}