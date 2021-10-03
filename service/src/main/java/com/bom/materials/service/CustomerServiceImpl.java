package com.bom.materials.service;

import com.bom.materials.exception.CustomerNotFoundException;
import com.bom.materials.model.Customer;
import com.bom.materials.model.CustomerResponse;
import com.bom.materials.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public CustomerResponse get(Integer id) {
        Customer customer = customerRepository.findByCustomerId(id).orElseThrow(() -> new CustomerNotFoundException("Customer is not found"));
        return new CustomerResponse(customer.getCustomerId());
    }
}
