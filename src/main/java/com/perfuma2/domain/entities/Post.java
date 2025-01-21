package com.perfuma2.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)  // La clave foránea está en la entidad Parfum
    @Column(name = "comment")
    private List<Comment> comments;

    @Column(name = "saves")
    private Integer saves;

    @Column(name = "active_post")
    private Boolean activePost;


}
