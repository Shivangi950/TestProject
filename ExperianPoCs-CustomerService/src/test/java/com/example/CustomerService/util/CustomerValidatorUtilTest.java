package com.example.CustomerService.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.CustomerService.Exception.CustomerServiceException;
import com.example.CustomerService.model.InputCustomer;

public class CustomerValidatorUtilTest {

	@ParameterizedTest
	@CsvSource(value={"null, null, 0, null", "a, null, 0, null", "null, a, 0, null", "null, null, 50, null", "null, null, 0, a"}, nullValues={"null"})
	void testValidateAmount(String customerName, String customerAddress, BigDecimal debitAvailable, String modeOfPayment) {
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName(customerName);
		inputCustomer.setCustomerAddress(customerAddress);
		inputCustomer.setDebitAvailable(debitAvailable);
		inputCustomer.setModeOfPayment(modeOfPayment);
		assertThrows(CustomerServiceException.class, () -> {
			CustomerValidator.validateCustomer(inputCustomer);
		});
	}
}
