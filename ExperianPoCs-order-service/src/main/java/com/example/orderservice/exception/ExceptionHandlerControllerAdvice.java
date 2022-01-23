package com.example.orderservice.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.orderservice.model.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerServiceException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleInvalidDataException(final CustomerServiceException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("Bad Request");
		error.setRequestedURI(request.getRequestURI());
		error.setReason(exception.getMessage());
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return error;
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleNotFoundException(final CustomerNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("Data Not Found");
		error.setRequestedURI(request.getRequestURI());
		error.setReason(exception.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return error;
	}

	@ExceptionHandler(DataAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public @ResponseBody ExceptionResponse handleDuplicateEntryException(final DataAlreadyExistsException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("Duplicate Data");
		error.setRequestedURI(request.getRequestURI());
		error.setReason(exception.getMessage());
		error.setErrorCode(HttpStatus.CONFLICT.value());
		return error;
	}

	@ExceptionHandler(InsufficientBalanceException.class)
	@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
	public @ResponseBody ExceptionResponse handleInsufficientBalanceException(
			final InsufficientBalanceException exception, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("Insufficient Balance");
		error.setRequestedURI(request.getRequestURI());
		error.setReason(exception.getMessage());
		error.setErrorCode(HttpStatus.REQUEST_TIMEOUT.value());
		return error;
	}

	@ExceptionHandler(CustomSQLException.class)
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
	public @ResponseBody ExceptionResponse handleSqlException(final CustomSQLException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setReason(exception.getMessage());
		error.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
		return error;
	}

}
