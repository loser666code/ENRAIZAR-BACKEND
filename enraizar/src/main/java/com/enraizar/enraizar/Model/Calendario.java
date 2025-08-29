package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "calendario")
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_calendario;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Funcionario funcionario;
    @Column (name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Calendario() {
    }

    public Calendario(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.data = new Date();
    }

    @PrePersist
    public void onCreate(){
        if (this.data == null){
            this.data = new Date();
        }
    }

    public int getId_calendario() {
        return id_calendario;
    }

    public void setId_calendario(int id_calendario) {
        this.id_calendario = id_calendario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
