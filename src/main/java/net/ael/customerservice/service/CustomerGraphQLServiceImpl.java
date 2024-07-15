package net.ael.customerservice.service;

import lombok.extern.slf4j.Slf4j;
import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;
import net.ael.customerservice.mapper.CustomerMapper;
import net.ael.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CustomerGraphQLServiceImpl implements CustomerGraphQLService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerGraphQLServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> findAllcustomers() {
        log.info("GraphQL SERVICE - findAllcustomers");
        List<Customer>customerList = customerRepository.findAll();
      //  List<CustomerDTO>customerDTOList = customerList.stream().map(customer -> customerMapper.fromCustomer(customer)).collect(Collectors.toList());
      //  return customerDTOList;
        return customerList.stream().map(customerMapper::fromCustomer).toList();

    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        log.info("GraphQL SERVICE - findCustomerById");

        Customer customer = customerRepository.findById(id).orElse(null);
        if( customer == null)
            throw new RuntimeException(String.format("Customer %s not found",id));

        return customerMapper.fromCustomer(customer);
    }
}
