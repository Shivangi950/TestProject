package com.example.CustomerService.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CustomerService.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}