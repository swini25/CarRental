package com.neu.swini.rentCarProject.dao;

import com.neu.swini.rentCarProject.exception.CustomerException;
import com.neu.swini.rentCarProject.pojo.Car;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarDao extends DAO{

    public Car createCar(Car car) throws Exception {
        try {
            begin();
            getSession().save(car);
            commit();
            close();
            return car;
        } catch (HibernateException e) {
            rollback();
            throw new CustomerException("Cannot add Car " + e.getMessage());
        }
    }

    public Car getCar(String city) throws Exception {

        Car car;
        try {
            Criteria criteria = getSession().createCriteria(Car.class);
            Criterion c1 =  Restrictions.eq("city", city);
            criteria.add(c1);
            car = (Car) criteria.uniqueResult();
        }catch (HibernateException e) {
            rollback();
            throw new Exception("Car Not Found "+ city, e);
        }
        return car;
    }

    public List<Car> list() throws Exception {
        try{
            Criteria criteria = getSession().createCriteria(Car.class);
            List<Car> list = criteria.list();
            return list;
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }

    }

    public Car getCarByLicenseNo(String licenseNo) throws Exception {
        Car car;
        try {
            Criteria criteria = getSession().createCriteria(Car.class);
            Criterion c1 =  Restrictions.eq("licenseNo", licenseNo);
            criteria.add(c1);
            car = (Car) criteria.uniqueResult();
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }
        return car;
    }

    public void deleteCar(Car car) throws Exception{
        try{
            begin();
            getSession().delete(car);
            commit();
            close();
        }catch (HibernateException e){
            rollback();
            throw new Exception("Cannot delete Car" + e.getMessage());
        }

    }

    public List<Car> listByCity( String city) throws Exception{
        try{
            Criteria criteria = getSession().createCriteria(Car.class);
            Car car = new Car();
            car.setCity(city);
            Example ex = Example.create(car);
            criteria.add(ex);
            List<Car> list = criteria.list();
            return list;
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }

    }

    public void updateCar(Car car) throws  Exception{
        try{
            begin();
            getSession().update(car);
            commit();
            close();
        }catch (HibernateException e){
            rollback();
            throw new Exception("Cannot delete Car" + e.getMessage());
        }
    }


    public List<Car> ownersCarList(String email) throws Exception {
        try{
            Criteria criteria = getSession().createCriteria(Car.class);
            Criterion c1  = Restrictions.eq("email", email);
            criteria.add(c1);
            List<Car> list = criteria.list();
            return list;
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }

    }

}
