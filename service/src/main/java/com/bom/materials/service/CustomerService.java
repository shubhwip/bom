package com.bom.materials.service;

import com.bom.materials.model.Customer;
import com.bom.materials.model.CustomerResponse;

public interface CustomerService {
    void save(Customer customer);

    CustomerResponse get(Integer id);

}
