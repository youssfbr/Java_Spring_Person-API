package com.github.youssfbr.person_api_2024.customers;

import com.github.youssfbr.person_api_2024.addresses.CreateAddressDTO;
import com.github.youssfbr.person_api_2024.phones.CreatePhoneDTO;

import java.util.List;

public record CreateCustomerDTO(

        String fullName ,

        String firstName ,

        String lastName ,

        String email ,

        String cpf ,

        String birthDate ,

        String note ,

        List<CreatePhoneDTO> phones ,

        CreateAddressDTO address
) {
}
