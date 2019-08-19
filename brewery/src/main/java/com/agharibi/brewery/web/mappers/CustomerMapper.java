package com.agharibi.brewery.web.mappers;

import com.agharibi.brewery.domain.Customer;
import com.agharibi.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}
