package com.melhamra.repository;

import com.melhamra.model.Customer;
import com.melhamra.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrders(Orders orders){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orders);
        session.getTransaction().commit();
        session.close();
    }

    public Orders getOrdersByID(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Orders orders = session.get(Orders.class,id);
        session.getTransaction().commit();
        session.close();
        return orders;
    }

    public List<Orders> getAllOrders(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Orders ");
        List<Orders> ordersList = query.list();
        session.getTransaction().commit();
        session.close();
        return ordersList;
    }

}
