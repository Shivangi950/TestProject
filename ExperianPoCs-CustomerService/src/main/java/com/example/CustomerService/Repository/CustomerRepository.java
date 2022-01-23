package com.example.CustomerService.Repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CustomerService.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Customer findByCustomerNameAndCustomerAddressAndDebitAvailable(String customerName, String customerAddress,
			BigDecimal debitAvailable);

}