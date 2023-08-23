package com.neu.swini.rentCarProject.pojo;


import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Entity
@Table(name= "licenseDetails", schema="rentCarProjectApp")
public class License {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private String customerName;
    private String customerLicense;
    private String licenseDocument;

    public License(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLicense() {
        return customerLicense;
    }

    public void setCustomerLicense(String customerLicense) {
        this.customerLicense = customerLicense;
    }

    public String getLicenseDocument() {
        return licenseDocument;
    }

    public void setLicenseDocument(String licenseDocument) {
        this.licenseDocument = licenseDocument;
    }
}
