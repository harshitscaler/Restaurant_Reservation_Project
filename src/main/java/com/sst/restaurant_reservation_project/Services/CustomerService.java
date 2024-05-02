package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Dtos.CustomerDto;
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

    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findByemail(customerDto.getEmail());

        if (customer == null) {
            customer = new Customer();
            customer.setName(customerDto.getName());
            customer.setContactNumber(customerDto.getContactNumber());
            customer.setEmail(customerDto.getEmail());
            customer =  customerRepository.save(customer);
        }
        return customer;
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

    public Customer updateCustomer(CustomerDto customerDto , Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerDto.getName());
        customer.setContactNumber(customerDto.getContactNumber());
        customer.setEmail(customerDto.getEmail());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

//    public Long getCustomerByEmail(String email) {
//        customerRepository.getCustomerIdFromEmail(email);
//    }

}
