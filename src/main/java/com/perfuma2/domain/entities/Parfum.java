package com.perfuma2.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parfum")
@Getter @Setter
public class Parfum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "batch_code")
    private String batchCode;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Opcional, dependiendo de cómo estés configurando la base de datos
    private User user;
}
