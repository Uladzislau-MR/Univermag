package com.vladislav.univermag.entity;


import javax.persistence.*;

@Entity
@Table(name = "plushkin_store_items")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String itemName;

    public Product() {
    }

    public Product(String itemName, String manufacturer, int yearOfManufacture, int quantity) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.quantity = quantity;
    }


    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "year_of_manufacture")
    private int  yearOfManufacture;
    @Column(name = "quantity")
    private Integer quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
