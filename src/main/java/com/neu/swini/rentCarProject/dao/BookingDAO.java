package com.neu.swini.rentCarProject.dao;

import com.neu.swini.rentCarProject.pojo.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDAO extends DAO {

    public Booking createUserBooking(Booking saveBooking) throws Exception {
        try {
            begin();
            getSession().save(saveBooking);
            commit();
            close();
            return saveBooking;
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getMessage());
        }
    }

    public Booking getBookingForCust(String customerEmail) throws Exception{

        Booking getUniqueBooking;
        try {
            Criteria c = getSession().createCriteria(Booking.class);
            Criterion emailCustomer =  Restrictions.eq("customerEmail", customerEmail);
            Criterion bookingStatus = Restrictions.eq("status", true);
            c.add(emailCustomer);
            c.add(bookingStatus);
            getUniqueBooking = (Booking) c.uniqueResult();
        }catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }
        return getUniqueBooking;
    }

    public List<Booking> list(String customerEmail) throws Exception {
        try {
            Criteria c = getSession().createCriteria(Booking.class);
            Criterion customer1 = Restrictions.eq("customerEmail", customerEmail);
            c.add(customer1);
            List<Booking> list = c.list();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e);
        }
    }

        public Booking getbyBookingId(int bookingId) throws Exception{

            Booking booking;
            try {
                Criteria criteria = getSession().createCriteria(Booking.class);
                Criterion c1 =  Restrictions.eq("id", bookingId);
                criteria.add(c1);
                booking = (Booking) criteria.uniqueResult();
            }catch (HibernateException e) {
                rollback();
                throw new Exception("Car Not Found "+ bookingId, e);
            }
            return booking;
        }

    public void updateBookingStatus(Booking booking) throws  Exception{
        try{
            begin();
            getSession().update(booking);
            commit();
            close();
        }catch (HibernateException e){
            rollback();
            throw new Exception("Cannot delete Car" + e.getMessage());
        }
    }





}
