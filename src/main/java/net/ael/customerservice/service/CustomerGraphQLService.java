package net.ael.customerservice.service;

import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;


import java.util.List;

public interface CustomerGraphQLService {

    public List<CustomerDTO> findAllcustomers();
    public CustomerDTO findCustomerById( Long id);
}
