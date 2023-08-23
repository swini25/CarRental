package com.neu.swini.rentCarProject.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "carDetails", schema = "rentCarProjectApp")
public class Car {
    private int id;
    private String email;
    private String company;
    private String model;
    private String city;
    private String makeYear;
    private String licenseNo;
    private String colour;
    private double price;
    private boolean available;

    public Car(){

    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company", nullable = true, length = 45)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name ="customerEmail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 45)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "makeYear", nullable = true, length = 45)
    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    @Basic
    @Column(name = "licenseNo", nullable = true, length = 45)
    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    @Basic
    @Column(name = "colour", nullable = true, length = 45)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name= "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name="available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Basic
    @Column(name="city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return id == that.id && Objects.equals(company, that.company) && Objects.equals(model, that.model) && Objects.equals(makeYear, that.makeYear) && Objects.equals(licenseNo, that.licenseNo) && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, model, makeYear, licenseNo, colour);
    }
}
