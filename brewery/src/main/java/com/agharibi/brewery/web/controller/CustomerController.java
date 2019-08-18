package com.agharibi.brewery.web.controller;

import com.agharibi.brewery.web.model.CustomerDto;
import com.agharibi.brewery.web.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private CustomerService customerService;


    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> handlePost(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto newCustomer  = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + newCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("id") UUID id,@Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") UUID id) {
        customerService.deleteById(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage() + " ");
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
