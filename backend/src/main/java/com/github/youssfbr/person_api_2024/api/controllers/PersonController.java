package com.github.youssfbr.person_api_2024.api.controllers;

import com.github.youssfbr.person_api_2024.customers.CreateCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class PersonController {

    private final ICustomerService customerService;

    public PersonController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createCustomer(@RequestBody @Valid CreateCustomerDTO dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok().build();
    }
}
