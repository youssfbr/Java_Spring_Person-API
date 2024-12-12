package com.github.youssfbr.person_api_2024.customers;

import com.github.youssfbr.person_api_2024.addresses.Address;
import com.github.youssfbr.person_api_2024.customers.dtos.CreateCustomerDTO;
import com.github.youssfbr.person_api_2024.customers.dtos.UpdateCustomerDTO;
import com.github.youssfbr.person_api_2024.phones.Phone;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "Customer")
@Table(name = "tb_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 14, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @Column(columnDefinition = "text")
    private String note;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones = new ArrayList<>();

    @Embedded
    private Address address;

    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Customer() { }

    public Customer(Long id , String fullName , String firstName , String lastName , String email , String cpf , LocalDate birthDate , String note , List<Phone> phones , Address address) {
        this.id = id;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.note = note;
        this.phones = phones;
        this.address = address;
    }

    public Customer(CreateCustomerDTO dto) {

     //   BeanUtils.copyProperties(dto , this);
        fullName = dto.fullName();
        firstName = dto.firstName();
        lastName = dto.lastName();
        email = dto.email();
        cpf = dto.cpf();


//        if (dto.birthDate() != null) {
//            birthDate = LocalDate.parse(dto.birthDate());
//        }

        note = dto.note();

        address = new Address(dto.address());

        dto.phones().forEach(ph -> phones.add(new Phone(ph)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @PrePersist
    public void prePersist() {
        active = Boolean.TRUE;
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public void inactivate() {
        active = false;
    }

    public Customer updateData(UpdateCustomerDTO dto) {
        if (dto.fullName() != null) fullName = dto.fullName();
        if (dto.firstName() != null) firstName = dto.firstName();
        if (dto.lastName() != null) lastName = dto.lastName();
        if (dto.email() != null) email = dto.email();
        if (dto.cpf() != null) cpf = dto.cpf();
        if (dto.birthDate() != null) birthDate = LocalDate.parse(dto.birthDate());
        if (dto.note() != null) note = dto.note();
        //if (dto.phones() != null) phones.
        if (dto.address() != null) address.updateData(dto.address());

        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return Objects.equals(id , customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
