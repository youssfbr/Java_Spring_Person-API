package com.github.youssfbr.person_api_2024.addresses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;



@Embeddable
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

    public Address() { }

    public Address(String cep , String publicPlace , String houseNumber , String supplement , String neighborhood , String city , String uf , String state , String region) {
        this.cep = cep;
        this.publicPlace = publicPlace;
        this.houseNumber = houseNumber;
        this.supplement = supplement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.uf = uf;
        this.state = state;
        this.region = region;
    }

    public Address(CreateAddressDTO dto) {
        if (dto != null) {
            BeanUtils.copyProperties(dto , this);
        }
    }

    public void updateData(@Valid CreateAddressDTO dto) {
        if (dto.cep() != null)          cep = dto.cep();
        if (dto.publicPlace() != null)  publicPlace = dto.publicPlace();
        if (dto.houseNumber() != null)  houseNumber = dto.houseNumber();
        if (dto.supplement() != null)   supplement = dto.supplement();
        if (dto.neighborhood() != null) neighborhood = dto.neighborhood();
        if (dto.city() != null)         city = dto.city();
        if (dto.uf() != null)           uf = dto.uf();
        if (dto.state() != null)        state = dto.state();
        if (dto.region() != null)       region = dto.region();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
