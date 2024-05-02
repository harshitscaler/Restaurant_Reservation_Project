package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Customer save(Customer customer);

    Customer findByemail(String email);
}
