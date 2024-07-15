package net.ael.customerservice.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;
import net.ael.customerservice.exception.CustomerNotFoundException;
import net.ael.customerservice.mapper.CustomerMapper;
import net.ael.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class CustomerRestServiceImpl implements CustomerRestService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerRestServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> findAllcustomers() {
        log.info("REST SERVICE - findAllcustomers");
        List<Customer>customerList = customerRepository.findAll();
      //  List<CustomerDTO>customerDTOList = customerList.stream().map(customer -> customerMapper.fromCustomer(customer)).collect(Collectors.toList());
       // return customerDTOList;
        return  customerList.stream().map(customerMapper::fromCustomer).toList();
    }

    @Override
    public CustomerDTO findCustomerById(@NonNull Long id) throws CustomerNotFoundException {
        log.info("REST SERVICE - findCustomerById");
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(String.format("customer %s not found" , id)));
        return customerMapper.fromCustomer(customer);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("sauvegarde du nouveau customer");
        Customer customer = customerMapper.fromCustomerDTO(customerDTO);
        Customer customerSave = customerRepository.save(customer);
        return customerMapper.fromCustomer(customerSave);
    }

    @Override
    public void deleteCustomer(@NonNull Long id) throws CustomerNotFoundException{
        customerRepository.deleteById(id);
    }
}
