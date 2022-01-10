package com.example.onlineshopnew.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "comenzi")
// cart itemurile corespunzatoare din comanda = doare ele sunt cumparate
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @Column(name="total_price")
    private int total;

    @OneToOne
    @JoinColumn(name="user_id")
    private User customer;

    public void setId(Long id) {
        this.id = id;
    }
}
