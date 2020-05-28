package com.melhamra.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Customer extends User{

    private String name;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Orders> listOrder = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ShoppingCart> listShoppingCart= new ArrayList<>();

}
