package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "setores")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_setor;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column (name = "descricao", length = 200, nullable = true)
    private String descrisao;

    public Setor() {
    }

    public Setor(int id_setor, String nome, String descrisao) {
        this.id_setor = id_setor;
        this.nome = nome;
        this.descrisao = descrisao;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
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
}
