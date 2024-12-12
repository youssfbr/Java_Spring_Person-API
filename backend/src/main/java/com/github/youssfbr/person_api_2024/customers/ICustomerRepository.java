package com.github.youssfbr.person_api_2024.customers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer , Long> {

    List<Customer> findAllByActiveTrue();
    Page<Customer> findAllPageByActiveTrue(Pageable pageable);

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
