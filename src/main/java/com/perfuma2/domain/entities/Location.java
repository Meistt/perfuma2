package com.perfuma2.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Location")
@Getter @Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "adress")
    private String adress;

    @Column(name = "locality")
    private String locality;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    private User user;


}
