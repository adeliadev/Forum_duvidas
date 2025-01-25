package com.project.forum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "notificacoes")
@Data
@AllArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idEmailDoUsuario;
    private String conteudo;
    private String tipoEvento;

    @Column(nullable = false)
    private LocalDate dataNotificao;

    // Adicionado
    // Relacionamento muitos para muitos com usuários
    @ManyToMany(mappedBy = "notificacoes")
    private List<Usuario> usuarios;

    // Sujeito a alteração de Resposta > Comentario
    @ManyToOne
    @JoinColumn(name = "id_comentario")
    private Comentario comentario;

    // Define data atual
    public Notificacao() {
        this.dataNotificao = LocalDate.now();
    }
}
