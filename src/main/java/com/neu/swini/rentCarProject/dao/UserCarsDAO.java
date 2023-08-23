package com.neu.swini.rentCarProject.dao;

import com.neu.swini.rentCarProject.exception.CustomerException;
import com.neu.swini.rentCarProject.pojo.UserCars;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

@Component
public class UserCarsDAO extends DAO{

    public UserCarsDAO(){

    }

    public UserCars createUserCars(UserCars userCars) throws Exception {
        try {
            begin();
            getSession().save(userCars);
            commit();
            close();
            return userCars;
        } catch (HibernateException e) {
            rollback();
            throw new CustomerException("Cannot add Car " + e.getMessage());
        }
    }
}
