package com.github.youssfbr.person_api_2024.addresses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(length = 10)
    private String cep;

    @Column(length = 100)
    private String publicPlace;

    @Column(length = 20)
    private String houseNumber;

    @Column(length = 100)
    private String supplement;

    @Column(length = 100)
    private String neighborhood;

    @Column(length = 100)
    private String city;

    @Column(length = 2)
    private String uf;

    @Column(length = 100)
    private String state;

    @Column(length = 100)
    private String region;

    public Address(CreateAddressDTO dto) {
        BeanUtils.copyProperties(dto , this);
    }
}
