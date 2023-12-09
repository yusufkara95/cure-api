package de.yusufkara.cureapi.Controller;

import de.yusufkara.cureapi.Exception.CustomerNotFoundException;
import de.yusufkara.cureapi.Model.Customer;
import de.yusufkara.cureapi.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{customerID}")
    Customer getCustomerById(@PathVariable Long customerID) {
        return customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
    }

    @PutMapping("/customer/{customerID}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long customerID) {
        return customerRepository.findById(customerID)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setStreetAddress(newCustomer.getStreetAddress());
                    customer.setHouseNumber(newCustomer.getHouseNumber());
                    customer.setPostalCode(newCustomer.getPostalCode());
                    customer.setCity(newCustomer.getCity());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setEmail(newCustomer.getEmail());

                    return customerRepository.save(customer);
                }).orElseThrow(() -> new CustomerNotFoundException(customerID));
    }

    @DeleteMapping("/customer/{customerID}")
    String deleteCustomer(@PathVariable Long customerID) {
        if(!customerRepository.existsById(customerID)) {
            throw new CustomerNotFoundException(customerID);
        }
        customerRepository.deleteById(customerID);
        return "Customer with id " + customerID + " has been deleted success.";
    }

}
