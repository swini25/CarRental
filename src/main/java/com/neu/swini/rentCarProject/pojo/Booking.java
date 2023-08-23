package com.neu.swini.rentCarProject.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "bookings", schema = "rentCarProjectApp")
public class Booking {
    private int bookingId;
    private String customerEmail;
    private String carLicenseNo;
    private String startDate;
    private String returnDate;
    private double price;
    private double totalPrice;
    private boolean status;

    public Booking(){

    }

    @Id
    @Column(name = "bookingId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    @Column(name = "customerEmail", nullable = false, length = 45)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    @Column(name = "carLicenseNo", nullable = false, length = 45)
    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }


    @Column(name = "startDate", nullable = false)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    @Column(name = "returnDate", nullable = false)
    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="totalPrice")
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking that = (Booking) o;
        return bookingId == that.bookingId && Objects.equals(customerEmail, that.customerEmail) && Objects.equals(carLicenseNo, that.carLicenseNo) && Objects.equals(startDate, that.startDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerEmail, carLicenseNo, startDate, returnDate);
    }
}
