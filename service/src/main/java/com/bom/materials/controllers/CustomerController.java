package com.bom.materials.controllers;

import com.bom.materials.model.Customer;
import com.bom.materials.model.CustomerResponse;
import com.bom.materials.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@Validated
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid Customer customer) {
        log.info("Saving customer details, {}", customer);
        customerService.save(customer);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().body(customerService.get(id));
    }

}
