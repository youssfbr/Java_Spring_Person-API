package com.github.youssfbr.person_api_2024.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer , Long> {
}
