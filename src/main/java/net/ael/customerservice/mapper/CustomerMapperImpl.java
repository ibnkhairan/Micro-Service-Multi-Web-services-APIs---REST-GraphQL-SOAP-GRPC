package net.ael.customerservice.mapper;

import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerDTO fromCustomer(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );

    }

    @Override
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {

        return new Customer(
                customerDTO.id(),
                customerDTO.name(),
                customerDTO.email());
    }
}
