package com.agharibi.brewery.web.service;

import com.agharibi.brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Tom Jones").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Leo Messi")
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        // TODO implement the update customer
        log.debug("Update a customer..");
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting a customer..");
    }
}
