package de.yusufkara.cureapi.controller;

import de.yusufkara.cureapi.model.Customer;
import de.yusufkara.cureapi.model.Job;
import de.yusufkara.cureapi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // http://localhost:8080/api/customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllUsers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // http://localhost:8080/api/users/1
    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getUserById(@PathVariable("customerId") Long customerId){
        Customer customer = customerService.getCustomberById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @DeleteMapping("{customerId}")
    public ResponseEntity<String> deleteUser(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }


}
