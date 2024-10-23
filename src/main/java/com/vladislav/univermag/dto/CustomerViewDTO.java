package com.vladislav.univermag.dto;

import com.vladislav.univermag.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class CustomerViewDTO {
    private int id;
    private String name;
    private String surname;
    private int height;
    private Set<Product> products = new HashSet<>();

    public CustomerViewDTO() {
    }

    public CustomerViewDTO(int id, String name, String surname, int height) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
