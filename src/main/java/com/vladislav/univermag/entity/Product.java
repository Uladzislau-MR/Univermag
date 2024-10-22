package com.vladislav.univermag.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plushkin_store_items")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToMany(mappedBy = "products")
    private Set<Customer> users = new HashSet<>();

    public Product() {
    }

    public Product(String itemName, String manufacturer, int yearOfManufacture, int quantity) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", itemName='" + itemName + '\'' +
               ", manufacturer='" + manufacturer + '\'' +
               ", yearOfManufacture=" + yearOfManufacture +
               ", quantity=" + quantity +
               '}';
    }
}
