package com.melhamra.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartDaoImpl {
    @Autowired
    SessionFactory sessionFactory;
}
