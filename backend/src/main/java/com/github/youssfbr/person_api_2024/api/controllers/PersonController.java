package com.github.youssfbr.person_api_2024.api.controllers;

import com.github.youssfbr.person_api_2024.customers.CreateCustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
public class PersonController {

    @PostMapping
    public ResponseEntity<CreateCustomerDTO> cadastrar(@RequestBody CreateCustomerDTO dto) {
        return ResponseEntity.ok(dto);
    }
}
