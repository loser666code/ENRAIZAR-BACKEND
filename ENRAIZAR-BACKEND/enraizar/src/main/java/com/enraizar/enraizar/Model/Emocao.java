package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

// Entidade JPA para Emoção
@Entity
@Table(name = "emocoes")
public class Emocao {
    // Identificador da emoção
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Descrição da emoção
    @Column(length = 100, nullable = false)
    private String descricao;

    // Valor associado (0..10)
    @Column(nullable = false)
    private Integer valor;

    // Retorna o ID
    public Integer getId() { return id; }
    // Define o ID
    public void setId(Integer id) { this.id = id; }

    // Retorna a descrição
    public String getDescricao() { return descricao; }
    // Define a descrição
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Retorna o valor
    public Integer getValor() { return valor; }
    // Define o valor
    public void setValor(Integer valor) { this.valor = valor; }
}
