package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login_email",length = 50, nullable = false)
    private String email;
    @Column(name = "senha",length = 60,nullable = false)
    private String senha;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    @Column(name = "tipo_usuario",length = 13,nullable = false)
    private String tipo_usuario;
    @Column(name = "id_setor",nullable = false)
    private int id_setor;

    public Funcionario() {
    }

    public Funcionario(int id, String email, String senha, String sobrenome, String nome, LocalDate data_nascimento, String cpf, String tipo_usuario, int id_setor) {
        this.id= id;
        this.email = email;
        this.senha = senha;
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.tipo_usuario = tipo_usuario;
        this.id_setor = id_setor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }
}
