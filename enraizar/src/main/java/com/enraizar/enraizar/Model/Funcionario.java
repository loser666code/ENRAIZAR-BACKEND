package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "login_email",length = 50, nullable = false)
    private String login_email;
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
    @Column(name="create_at",nullable = false)
    private LocalDateTime create_at;
    @Column(name="update_at",nullable = false)
    private LocalDateTime update_at;
    @ManyToOne
    @JoinColumn(name = "id_setor", referencedColumnName = "id_setor")
    private Setor setor;

    public Funcionario() {
    }

    public Funcionario(int id_usuario, String login_email, String senha, String sobrenome, String nome, LocalDate data_nascimento, String cpf, String tipo_usuario, LocalDateTime create_at, LocalDateTime update_at, Setor setor) {
        this.id_usuario = id_usuario;
        this.login_email = login_email;
        this.senha = senha;
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.tipo_usuario = tipo_usuario;
        this.create_at = create_at;
        this.update_at = update_at;
        this.setor = setor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_email() {
        return login_email;
    }

    public void setLogin_email(String login_email) {
        this.login_email = login_email;
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

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
