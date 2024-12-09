package com.github.youssfbr.person_api_2024.phones;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Phone")
@Table(name = "tb_phones")
@EqualsAndHashCode(of = "id")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PhoneType type;

    @Column(nullable = false, length = 20)
    private String number;

    public Phone(CreatePhoneDTO dto) {
        BeanUtils.copyProperties(dto , this);
    }
}
