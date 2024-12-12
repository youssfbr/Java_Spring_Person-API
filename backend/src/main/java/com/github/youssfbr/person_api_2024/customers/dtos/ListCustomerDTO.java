package com.github.youssfbr.person_api_2024.customers.dtos;

import com.github.youssfbr.person_api_2024.customers.Customer;
import com.github.youssfbr.person_api_2024.phones.ListPhoneDTO;

import java.util.List;

public record ListCustomerDTO(

        Long id ,

        String fullName ,

        String firstName ,

        String lastName ,

        String cpf ,

        String birthDate ,

        String note ,

        List<ListPhoneDTO> phones
) {
    public ListCustomerDTO(Customer entity) {
        this(
                entity.getId() ,
                entity.getFullName() ,
                entity.getFirstName() ,
                entity.getLastName() ,
                entity.getCpf() ,
                String.valueOf(entity.getBirthDate()) ,
                entity.getNote() ,

                entity.getPhones()
                        .stream()
                        .map(ListPhoneDTO::new)
                        .toList()
        );
    }
}
