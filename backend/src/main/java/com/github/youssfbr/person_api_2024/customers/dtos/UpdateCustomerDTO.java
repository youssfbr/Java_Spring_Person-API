package com.github.youssfbr.person_api_2024.customers.dtos;

import com.github.youssfbr.person_api_2024.addresses.CreateAddressDTO;
import com.github.youssfbr.person_api_2024.phones.CreatePhoneDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record UpdateCustomerDTO(

        @NotNull
        Long id ,

        @Size(max = 100)
        String fullName ,

        @Size(max = 20)
        String firstName ,

        @Size(max = 20)
        String lastName ,

        @Email
        @Size(max = 100)
        String email ,

        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf ,

        String birthDate ,

        String note ,

        @Valid
        List<CreatePhoneDTO> phones ,

        @Valid
        CreateAddressDTO address
) {
}
