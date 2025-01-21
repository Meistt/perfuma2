package com.perfuma2.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne
    private Location location;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)  // La clave foránea está en la entidad Parfum
    private List<Parfum> parfums;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Column(name = "post")
    private List<Post> posts;

}
