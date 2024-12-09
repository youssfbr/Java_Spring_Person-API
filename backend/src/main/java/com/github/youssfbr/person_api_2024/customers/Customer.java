package com.github.youssfbr.person_api_2024.customers;

import com.github.youssfbr.person_api_2024.addresses.Address;
import com.github.youssfbr.person_api_2024.phones.Phone;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
@Table(name = "tb_customers")
@EqualsAndHashCode(of = "id")
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

    public Customer(CreateCustomerDTO dto) {

        BeanUtils.copyProperties(dto , this);
        birthDate = LocalDate.parse(dto.birthDate());

        address = new Address(dto.address());

        dto.phones().forEach(ph -> phones.add(new Phone(ph)));
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

}
