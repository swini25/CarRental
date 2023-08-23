package com.neu.swini.rentCarProject.dao;

import com.neu.swini.rentCarProject.exception.CustomerException;
import com.neu.swini.rentCarProject.pojo.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO extends DAO{

    public Customer createCustomer(Customer customer) throws CustomerException {
        try {
            begin();
            getSession().save(customer);
            commit();
            close();
            return customer;
        } catch (HibernateException e) {
            rollback();
            throw new CustomerException("Cannot create Customer " + e.getMessage());
        }
    }

    public Customer customerLogin(String email){
        return getSession().get(Customer.class, email);
    }

    public Customer getCustomer(String email, String category) throws CustomerException {


        Customer customer ;
        try {
            Criteria criteria = getSession().createCriteria(Customer.class);
            Criterion c1 =  Restrictions.eq("email", email);
            criteria.add(c1);
            Criterion c2 =  Restrictions.eq("category", category);
            criteria.add(c2);
            customer = (Customer) criteria.uniqueResult();
        }catch (HibernateException e) {
            rollback();
            throw new CustomerException("Customer Not Found "+email, e);
        }
        return customer;
    }

    public List<Customer> list() throws Exception {
        try{
            Criteria criteria = getSession().createCriteria(Customer.class);
            List<Customer> list = criteria.list();
            return list;
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }
    }

    public void deleteCustomer(Customer customer) throws CustomerException{
        try{
            begin();
            getSession().delete(customer);
            commit();
            close();
        }catch (HibernateException e){
            rollback();
            throw new CustomerException("Cannot delete Customer" + e.getMessage());
        }

    }

    public void updateCustomer(Customer customer) throws Exception{
        try{
            begin();
            getSession().update(customer);
            commit();
            close();
        }catch (HibernateException e){
            rollback();
            throw new CustomerException("Cannot update Customer" + e.getMessage());
        }
    }

}
