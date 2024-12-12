package com.github.youssfbr.person_api_2024.api.controllers;

import com.github.youssfbr.person_api_2024.customers.ICustomerService;
import com.github.youssfbr.person_api_2024.customers.dtos.CreateCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.CustomerDetailDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.ListCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.UpdateCustomerDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ListCustomerDTO>> paginar(
            @PageableDefault(size = 10 , page = 0 , sort = {"fullName"}) Pageable pageable) {
        return ResponseEntity.ok(customerService.page(pageable));
    }

    @GetMapping
    public ResponseEntity<List<ListCustomerDTO>> listAll() {
        return ResponseEntity.ok(customerService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailDTO> detail(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.detail(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDetailDTO> createCustomer(@RequestBody @Valid CreateCustomerDTO dto) {
        final CustomerDetailDTO customerCreated = customerService.createCustomer(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(customerCreated.id()).toUri();

        return ResponseEntity.created(uri).body(customerCreated);
    }

    @PutMapping
    public  ResponseEntity<CustomerDetailDTO> update(@RequestBody @Valid UpdateCustomerDTO dto) {
        return ResponseEntity.ok(customerService.updateCustomer(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
