package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {

        Iterable<Customer> customers =  customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        customers.forEach(customerList::add);
        return customerList;
    }

    public Customer updateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

//    public Long getCustomerByEmail(String email) {
//        customerRepository.getCustomerIdFromEmail(email);
//    }

}
