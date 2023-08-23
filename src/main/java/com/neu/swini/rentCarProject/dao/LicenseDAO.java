package com.neu.swini.rentCarProject.dao;


import com.neu.swini.rentCarProject.pojo.License;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;


@Component
public class LicenseDAO extends DAO{

    public License create(License license) throws Exception {
        try {
            //save user object in the database
            begin();
            getSession().save(license);
            commit();
            close();

            return license;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Error while uploading License: " + e.getMessage());
        }
    }
}
