package com.github.youssfbr.person_api_2024.customers;

import com.github.youssfbr.person_api_2024.customers.dtos.CreateCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.CustomerDetailDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.ListCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.UpdateCustomerDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<ListCustomerDTO> page(Pageable pageable);
    List<ListCustomerDTO> listAll();
    CustomerDetailDTO detail(Long id);

    CustomerDetailDTO createCustomer(CreateCustomerDTO dto);
    void updateCustomer(@Valid UpdateCustomerDTO dto);

    void delete(Long id);
}
