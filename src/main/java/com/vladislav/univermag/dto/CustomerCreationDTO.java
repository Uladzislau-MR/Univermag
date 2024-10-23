package com.vladislav.univermag.dto;

public class CustomerCreationDTO {
    private int id;
    private String name;
    private String surname;
    private int height;
    private int BirthYear;


    public CustomerCreationDTO(int id, String name, String surname, int height, int BirthYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.BirthYear = BirthYear;
    }

    public CustomerCreationDTO() {
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

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int BirthYear) {
        this.BirthYear = BirthYear;
    }
}
