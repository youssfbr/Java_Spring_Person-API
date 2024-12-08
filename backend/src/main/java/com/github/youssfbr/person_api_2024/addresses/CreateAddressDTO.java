package com.github.youssfbr.person_api_2024.addresses;

public record CreateAddressDTO(

        String cep ,
        String publicPlace ,
        String houseNumber ,
        String supplement ,
        String neighborhood ,
        String city ,
        String uf ,
        String state ,
        String region
) {
}
