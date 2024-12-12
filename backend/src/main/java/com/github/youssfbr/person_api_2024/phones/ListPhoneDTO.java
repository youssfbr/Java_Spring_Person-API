package com.github.youssfbr.person_api_2024.phones;

public record ListPhoneDTO(

        Long id ,

        PhoneType type ,

        String number
) {
    public ListPhoneDTO(Phone entity) {
        this(
                entity.getId() ,
                entity.getType() ,
                entity.getNumber()
        );
    }
}
