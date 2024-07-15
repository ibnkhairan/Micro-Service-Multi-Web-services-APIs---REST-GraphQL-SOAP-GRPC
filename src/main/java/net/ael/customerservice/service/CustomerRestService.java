package net.ael.customerservice.service;

import lombok.NonNull;
import net.ael.customerservice.dto.CustomerDTO;

import net.ael.customerservice.exception.CustomerNotFoundException;


import java.util.List;

public interface CustomerRestService {

    public List<CustomerDTO> findAllcustomers();
    public CustomerDTO findCustomerById(Long id) throws CustomerNotFoundException;
    public CustomerDTO saveCustomer(CustomerDTO customerDTO);

    void deleteCustomer(@NonNull Long id) throws CustomerNotFoundException;
}
