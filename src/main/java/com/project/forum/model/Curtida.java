package com.project.forum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

// Define uma restrição única para os campos post_id e usuario_id.
// Isso garante que o mesmo usuário não possa curtir a mesma postagem mais de uma vez.
@Table(name = "curtidas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"post_id", "usuario_id"})
})
public class Curtida {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Postagem postagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
