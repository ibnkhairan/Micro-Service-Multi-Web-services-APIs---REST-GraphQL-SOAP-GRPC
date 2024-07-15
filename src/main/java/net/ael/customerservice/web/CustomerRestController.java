package net.ael.customerservice.web;

import lombok.extern.slf4j.Slf4j;
import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.entities.Customer;
import net.ael.customerservice.exception.CustomerNotFoundException;
import net.ael.customerservice.repository.CustomerRepository;
import net.ael.customerservice.service.CustomerRestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
public class CustomerRestController {

    private final CustomerRestService customerRestService;

    public CustomerRestController(CustomerRestService customerRestService) {
        this.customerRestService = customerRestService;

    }

    @GetMapping("/customers")
    public List<CustomerDTO> customerList(){

        return customerRestService.findAllcustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO findCustomerById(@PathVariable Long id){
        try{
            return customerRestService.findCustomerById(id);
        }catch(CustomerNotFoundException e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }

    }

    @PostMapping("customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
              return customerRestService.saveCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        try {
            customerRestService.deleteCustomer(id);
        }catch (CustomerNotFoundException e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(),e);
        }
    }
}
