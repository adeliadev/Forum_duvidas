package com.project.forum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nomeDeUsuario;
   private String senha;
   private String nome;
   private String email;

   // Relacionamento bidirecional com postagem
   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Postagem> postagens;

   private String tipo;

   @Column(nullable = false) //Expecifica que essa coluna não pode receber valores nulos
   private LocalDate dataCadastro;

   private String bio;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentario;

    // Adicionado
    // Relacionamento muitos para muitos com notificações
    @ManyToMany
    @JoinTable(
            name = "usuario_notificacao",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "notificacao_id")
    )
    private List<Notificacao> notificacoes;

   // Define data atual
   public Usuario() {
       this.dataCadastro = LocalDate.now();
   }
}
