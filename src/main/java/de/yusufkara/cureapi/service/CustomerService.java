package de.yusufkara.cureapi.service;

import de.yusufkara.cureapi.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomberById(Long customerId);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
}
