package com.melhamra.controller;

import com.melhamra.model.Orders;
import com.melhamra.repository.CustomerDaoImpl;
import com.melhamra.repository.OrdersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private final OrdersDaoImpl ordersDao;
    @Autowired
    private final CustomerDaoImpl customerDao;

    public OrdersController(OrdersDaoImpl ordersDao, CustomerDaoImpl customerDao) {
        this.ordersDao = ordersDao;
        this.customerDao = customerDao;
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersDao.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Orders getOrdersById(@PathVariable int id){
        return ordersDao.getOrdersByID(id);
    }


}
