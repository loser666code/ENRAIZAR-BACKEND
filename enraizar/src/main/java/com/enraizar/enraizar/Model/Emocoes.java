package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "emocoes")
public class Emocoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emocao;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "valor", nullable = false)
    private int valor;

    public Emocoes() {
    }

    public int getIdEmocao() {
        return id_emocao;
    }

    public void setIdEmocao(int id_emocao) {
        this.id_emocao = id_emocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
