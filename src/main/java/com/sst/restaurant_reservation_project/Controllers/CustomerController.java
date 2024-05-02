package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.CustomExceptions.CustomerNotFound;
import com.sst.restaurant_reservation_project.CustomExceptions.DepartmentNotFound;
import com.sst.restaurant_reservation_project.Dtos.CustomerDto;
import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Repositories.CustomerRepository;
import com.sst.restaurant_reservation_project.Services.CustomerService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("")
    public List<Customer> fetchAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer newCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {

        Customer updatedCustomer = customerService.updateCustomer(customerDto, customerId);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId) {
        if(customerService.getCustomerById(customerId) == null) {
            throw new CustomerNotFound(customerId);
        }
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
