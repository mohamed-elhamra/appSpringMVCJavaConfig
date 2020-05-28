package com.melhamra.controller;

import com.melhamra.model.Customer;
import com.melhamra.repository.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerDaoImpl customerDao;

    public CustomerController(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerDao.getCustomerByID(id);
    }

    @PostMapping("/customers")
    public void saveCustomer(@RequestBody Customer customer){
        customer.getListOrder()
                .forEach( orders -> orders.setCustomer(customer));
        customer.getListShoppingCart()
                .forEach( shoppingCart -> shoppingCart.setCustomer(customer));
        customerDao.saveCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        Customer customer = customerDao.getCustomerByID(id);
        customerDao.deleteCustomer(customer);
    }

    @PatchMapping("/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer,
                               @PathVariable int id){
        Customer customer1 = customerDao.getCustomerByID(id);
        customer1.setAddress(customer.getAddress());
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPassword(customer.getPassword());
        
        customerDao.updateCustomer(customer1);
    }



}
