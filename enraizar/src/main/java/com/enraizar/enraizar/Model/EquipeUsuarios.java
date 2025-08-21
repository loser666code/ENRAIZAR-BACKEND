package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_equipe")
public class EquipeUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;
    @Column(name = "Cargo",length = 40, nullable = false)
    private String cargo;

    public EquipeUsuarios() {
    }

    public EquipeUsuarios(int id, Funcionario funcionario, Equipe equipe, String cargo) {
        this.id = id;
        this.funcionario = funcionario;
        this.equipe = equipe;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
