package de.yusufkara.cureapi.repository;

import de.yusufkara.cureapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
