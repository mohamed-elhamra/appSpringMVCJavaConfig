package com.melhamra.repository;


import com.melhamra.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        session.getTransaction().commit();
        session.close();
        return customerList;
    }

    public Customer getCustomerByID(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    public void deleteCustomer(Customer customer){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void updateCustomer(Customer customer){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

}

