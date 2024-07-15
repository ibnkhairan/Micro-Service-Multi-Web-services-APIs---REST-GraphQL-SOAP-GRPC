package net.ael.customerservice.mapper;

import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;

public interface CustomerMapper {
    CustomerDTO fromCustomer(Customer customer);
    Customer fromCustomerDTO(CustomerDTO customerDTO);
}
