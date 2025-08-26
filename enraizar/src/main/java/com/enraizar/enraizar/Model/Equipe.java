package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "equipes")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", length = 45,nullable = false)
    private String nome;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public Equipe() {
    }

    public Equipe(int id, String nome, String descricao, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @PrePersist
    public void onCreated(){
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdated(){
        this.updated_at = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
