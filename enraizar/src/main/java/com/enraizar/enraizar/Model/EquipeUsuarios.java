package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_equipe")
public class EquipeUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_usuario", nullable = false)
    private int id_usuario;
    @Column(name = "id_equipe", nullable = false)
    private int id_equipe;
    @Column(name = "Cargo", length = 40, nullable = false)
    private String cargo;

    public EquipeUsuarios() {
    }

    public EquipeUsuarios(int id, int id_usuario, int id_equipe, String cargo) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_equipe = id_equipe;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
