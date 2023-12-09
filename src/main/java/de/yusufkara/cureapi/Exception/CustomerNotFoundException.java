package de.yusufkara.cureapi.Exception;

public class CustomerNotFoundException extends RuntimeException{

    // You get an error message, if you cant find the specific customer
    public CustomerNotFoundException(Long id) {
        super("Could not found the customer with id " + id);
    }

}

