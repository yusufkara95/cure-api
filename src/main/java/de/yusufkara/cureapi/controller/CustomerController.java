package de.yusufkara.cureapi.controller;

import de.yusufkara.cureapi.domain.Customer;
import de.yusufkara.cureapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
