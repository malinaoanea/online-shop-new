package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long id;
    private String category_name;
    @JsonIgnore
    private List<Product> products;

    public CategoryDto(long id) {
        this.id = id;
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
                '"'+ "category_name"+ '"'+ ":" + '"' + category_name + '"'  +  "," +
                '"'+ "products"+ '"'+ ":" +  products  +

                "}" ;
    }
}
