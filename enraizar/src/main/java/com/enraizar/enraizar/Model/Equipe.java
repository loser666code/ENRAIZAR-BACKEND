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
    private String descrisao;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    public Equipe() {
    }

    public Equipe(String nome, int id, String descrisao, LocalDateTime created_at) {
        this.nome = nome;
        this.id = id;
        this.descrisao = descrisao;
        this.created_at = created_at;
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

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
