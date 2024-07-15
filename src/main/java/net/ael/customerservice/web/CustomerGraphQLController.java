package net.ael.customerservice.web;

import net.ael.customerservice.dto.CustomerDTO;
import net.ael.customerservice.service.CustomerGraphQLService;
import net.ael.customerservice.service.CustomerRestService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerGraphQLController {

    private final CustomerGraphQLService customerGraphQLService;

    public CustomerGraphQLController( CustomerGraphQLService customerGraphQLService) {
        this.customerGraphQLService = customerGraphQLService;


    }

    @QueryMapping
    public List<CustomerDTO> allCustomers(){
        return customerGraphQLService.findAllcustomers();
    }

    @QueryMapping
    public CustomerDTO customerById(@Argument Long id){
               return customerGraphQLService.findCustomerById(id);
    }

}
