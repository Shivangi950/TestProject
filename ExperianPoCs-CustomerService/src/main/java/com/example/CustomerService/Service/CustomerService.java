package com.example.CustomerService.Service;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomerService.Exception.CustomSQLException;
import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Exception.DataAlreadyExistsException;
import com.example.CustomerService.Exception.InsufficientBalanceException;
import com.example.CustomerService.Repository.CustomerRepository;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.Customer.StatusEnum;
import com.example.CustomerService.model.CustomerAmount;
import com.example.CustomerService.model.InputCustomer;
import com.example.CustomerService.util.CustomerValidator;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomerById(int id) {
		Customer customer = null;
		try {
			customer = customerRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomerNotFoundException("customer not found");
		}
		return customer;
	}

	public Customer addCustomer(@Valid InputCustomer inputCustomer) {
		Customer customer = new Customer();
		customer.setStatus(StatusEnum.ACTIVE);
		customer.setCustomerName(inputCustomer.getCustomerName());
		customer.setCustomerAddress(inputCustomer.getCustomerAddress());
		customer.setDebitAvailable(inputCustomer.getDebitAvailable());
		customer.setModeOfPayment(inputCustomer.getModeOfPayment());
		return customerRepository.save(customer);
	}
	
	@Transactional(rollbackFor = {CustomSQLException.class})
	public Customer createCustomerWithRuntimeException(@Valid InputCustomer inputCustomer) {
		/**
		 *	below throws 400 for invalid input
		 */
		CustomerValidator.validateCustomer(inputCustomer);
				
		Customer newCustomer = customerRepository.findByCustomerNameAndCustomerAddressAndDebitAvailable(inputCustomer.getCustomerName(), inputCustomer.getCustomerAddress(), inputCustomer.getDebitAvailable());
		
		Customer addedCustomer = null;
		
		if (newCustomer == null) {
			addedCustomer = addCustomer(inputCustomer);
			System.out.println("Customer successfully created");
			
          if(addedCustomer.getCustomerName().length() >=10) {
        	  System.out.println("name exceeds 10 characters");
        	  throw new CustomSQLException("Throwing exception for Rollback");
          }  
			
		} else {
				System.out.println("This customer already exists!");
				throw new DataAlreadyExistsException("customer already Exists");
			}
		return addedCustomer; 
		}
	
	@Transactional(rollbackFor = {CustomSQLException.class})
	public Customer creditAmountCustomer(CustomerAmount customerAmount) {

        /**
		 * below method will handle 400
		 */
		CustomerValidator.validateAmount(customerAmount);
		/**
		 * below method will handle 404
		 */
		Customer customer = getCustomerById(customerAmount.getCustomerId());
		BigDecimal addedValue = customer.getDebitAvailable().add(customerAmount.getValue());
		customer.setDebitAvailable(addedValue);
		Customer addedCustomer = customerRepository.save(customer);
		
		BigDecimal b1 = new BigDecimal(40000);
		
		if ((customer.getDebitAvailable().compareTo(b1) == 0) || (customer.getDebitAvailable().compareTo(b1) > 0)) {
			System.out.println("Credit cannot be done!");
			throw new CustomSQLException("Throwing exception for Rollback");
		}
		return addedCustomer;
	}

	@Transactional(rollbackFor = {InsufficientBalanceException.class})
	public Customer debitAmountCustomer(CustomerAmount customerAmount) throws InsufficientBalanceException{
		Customer addedCustomer = null;
        /**
		 * below method will handle 400
		 */
		CustomerValidator.validateAmount(customerAmount);
		/**
		 * below method will handle 404
		 */
		Customer customer = getCustomerById(customerAmount.getCustomerId());
		BigDecimal subtractVal = customer.getDebitAvailable().subtract(customerAmount.getValue());
	if (subtractVal.compareTo(BigDecimal.ZERO) > 0) {

			customer.setDebitAvailable(subtractVal);
			addedCustomer = customerRepository.save(customer);
			/*BigDecimal b1 = new BigDecimal(1000);
			
			if ((customer.getDebitAvailable().compareTo(b1) == 0) || (customer.getDebitAvailable().compareTo(b1) < 0)) {
				System.out.println("Debit cannot be done!");
				throw new CustomSQLException("Throwing exception for Rollback");
			}
          */
		} else {
			System.out.println("insufficient amount to perform debit");
			throw new InsufficientBalanceException("insufficient amount to perform debit");
		}
		return addedCustomer;
		
	}
}
