package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.model.Lot;
import lombok.*;

import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto{
    private long id;
    private String name;
    @Min(1)
    private int price;
    private Category category;
    private Lot lot;

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public ProductDto(long id) {
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
                '"'+ "name"+ '"'+ ":" + '"' + name + '"'  +  "," +
                '"'+ "lot_id"+ '"'+ ":" + '"' + lot + '"'  +  "," +
                '"'+ "category_id"+ '"'+ ":" + '"' + category+ '"'  +  "," +
                '"'+ "price"+ '"'+ ":" +  price  +

                "}" ;
    }
}