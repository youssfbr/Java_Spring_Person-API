package com.github.youssfbr.person_api_2024.customers;

import com.github.youssfbr.person_api_2024.customers.dtos.CreateCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.CustomerDetailDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.ListCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.UpdateCustomerDTO;
import com.github.youssfbr.person_api_2024.infra.exceptions.CpfException;
import com.github.youssfbr.person_api_2024.infra.exceptions.EmailException;
import com.github.youssfbr.person_api_2024.infra.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ListCustomerDTO> page(Pageable pageable) {
        return customerRepository.findAllPageByActiveTrue(pageable)
                .map(ListCustomerDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListCustomerDTO> listAll() {
        return customerRepository.findAllByActiveTrue()
                .stream()
                .map(ListCustomerDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDetailDTO detail(Long id) {
        return customerRepository.findById(id)
                .map(CustomerDetailDTO::new).orElseThrow();
    }

    @Override
    @Transactional
    public CustomerDetailDTO createCustomer(CreateCustomerDTO dto) {

        checkIfCfpExists(dto.cpf());
        checkIfEmailExists(dto.email());

        final Customer saved = customerRepository.save(new Customer(dto));
        return new CustomerDetailDTO(saved);
    }

    @Override
    @Transactional
    public void updateCustomer(UpdateCustomerDTO dto) {

        try {
            final Customer customer = getReferenceById(dto.id());

            if (!dto.cpf().equals(customer.getCpf())) {
                checkIfCfpExists(dto.cpf());
            }

            if (!dto.email().equals(customer.getEmail())) {
                checkIfEmailExists(dto.email());
            }

            customer.updateData(dto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource with ID " + dto.id() + " Not found");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            final Customer customer = getReferenceById(id);
            customer.inactivate();
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource with ID " + id + " Not found");
        }
    }

    private Customer getReferenceById(Long id) {
            return customerRepository.getReferenceById((id));
    }

    private void checkIfEmailExists(String email) {
        if (email != null && customerRepository.existsByEmail(email)) {
                throw new EmailException("e-mail already exists.");
        }
    }

    private void checkIfCfpExists(String cpf) {
        if (cpf != null && customerRepository.existsByCpf(cpf) ) {
            throw new CpfException("CPF already exists.");
        }
    }

}
