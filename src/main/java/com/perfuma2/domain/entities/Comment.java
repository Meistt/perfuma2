package com.perfuma2.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "comment")
@Setter @Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_content")
    private String content;

    // Relación muchos a uno con Post
    @ManyToOne
    @JoinColumn(name = "post_id")  // Clave foránea en Comment que apunta a Post
    private Post post;

    // Relación uno a muchos consigo misma (comentarios en cascada)
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<Comment> replies;

    // Relación muchos a uno consigo misma (un comentario puede ser respondido por otro)
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")  // Clave foránea en Comment para el comentario padre
    private Comment parentComment;

}
