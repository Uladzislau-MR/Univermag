package com.vladislav.univermag.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    @Column(name = "birth_Year")
    private int birthYear;
    @Column(name = "height")
    private int height;

    public Customer() {
    }

    public Customer(String name, String surname, int birthYear, int height) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.height = height;
    }


    @ManyToMany() //при ленивой загрузке список покупок не отражается
    @JoinTable(
            name = "customer_products",
            joinColumns = @JoinColumn(name = "cust_id", referencedColumnName="customer_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id",  referencedColumnName="item_id" )
    )
    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return products;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", birthYear=" + birthYear +
               ", height=" + height +
               '}';
    }
}
