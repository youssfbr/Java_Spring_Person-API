package com.github.youssfbr.person_api_2024.addresses;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAddressDTO(

        @Size(max = 10)
        @Pattern(regexp = "\\d{8}")
        String cep ,

        @Size(max = 100)
        String publicPlace ,

        @Size(max = 20)
        String houseNumber ,

        @Size(max = 100)
        String supplement ,

        @Size(max = 100)
        String neighborhood ,

        @Size(max = 100)
        String city ,

        @Size(max = 2)
        String uf ,

        @Size(max = 100)
        String state ,

        @Size(max = 100)
        String region
) {
}
