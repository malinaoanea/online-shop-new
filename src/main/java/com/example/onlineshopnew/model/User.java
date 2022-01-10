package com.example.onlineshopnew.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "usertype")
    private String usertype;

    @NotNull
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;



    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User(String name, String surname, String usertype, String email) {
        this.name = name;
        this.surname = surname;
        this.usertype = usertype;
        this.email = email;
    }
}
