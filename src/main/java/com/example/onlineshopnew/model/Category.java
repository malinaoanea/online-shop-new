package com.example.onlineshopnew.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_name")
    private String category_name;

    public Category(long id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public long getId() {
        return id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCategory_name() {
        return category_name;
    }

    public Category(long id) {
        this.id = id;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }
}
