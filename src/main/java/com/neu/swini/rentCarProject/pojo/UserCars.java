package com.neu.swini.rentCarProject.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "userCars", schema = "rentCarProjectApp")
public class UserCars {
    private int userId;
    private int carId;

    public UserCars(){

    }

    @Id
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "carId", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCars that = (UserCars) o;
        return userId == that.userId && carId == that.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, carId);
    }
}
