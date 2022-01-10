package com.example.onlineshopnew.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;

    private String surname;
    private String name;

    private String usertype;

    public UserDto(Long id, String email, String surname, String name, String usertype) {
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.usertype = usertype;
        this.id = id;
    }

    public UserDto(String email) {
        this.email = email;
    }

    public String tostring() {
//        return  "{ \n"+
//                '"'+ "id"+ '"'+ ":"  + id +  ",\n" +
//                '"'+ "email"+ '"'+ ":" + '"' + email + '"'  +  ",\n" +
//                '"'+ "surname"+ '"'+ ":" + '"' + surname + '"'  +  ",\n" +
//                '"'+ "name"+ '"'+ ":" + '"' + name + '"'  +  ",\n" +
//                '"'+ "usertype"+ '"'+ ":" + '"' + usertype + '"'  +  "\n" +
//
//"}" ;
        return  "{"+
                '"'+ "id"+ '"'+ ":"  + id +  "," +
                '"'+ "email"+ '"'+ ":" + '"' + email + '"'  +  "," +
                '"'+ "surname"+ '"'+ ":" + '"' + surname + '"'  +  "," +
                '"'+ "name"+ '"'+ ":" + '"' + name + '"'  +  "," +
                '"'+ "usertype"+ '"'+ ":" + '"' + usertype + '"'  +

                "}" ;
    }
}
