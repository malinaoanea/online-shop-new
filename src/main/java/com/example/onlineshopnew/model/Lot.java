package com.example.onlineshopnew.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "loturi")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Lot(Long id) {
        this.id = id;
    }

    @Column(name = "number")
    private int number;

    @Column(name = "nume_lot")
    private String nume_lot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}