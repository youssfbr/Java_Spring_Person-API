package com.github.youssfbr.person_api_2024.phones;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;


@Entity(name = "Phone")
@Table(name = "tb_phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PhoneType type;

    @Column(nullable = false, length = 20)
    private String number;

    public Phone() { }

    public Phone(Long id , PhoneType type , String number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public Phone(CreatePhoneDTO dto) {
        BeanUtils.copyProperties(dto , this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;
        return Objects.equals(id , phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
