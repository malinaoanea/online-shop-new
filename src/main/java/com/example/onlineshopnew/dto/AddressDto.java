package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private long id;
    private User user;
    private String adress;

}
