package com.enraizar.enraizar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "calendario_emocoes")
public class CalendarioEmocoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_calendario")
    private Calendario calendario;
    @ManyToOne
    @JoinColumn(name = "id_emocao")
    private Emocoes emocao;

    public CalendarioEmocoes() {
    }

    public CalendarioEmocoes(Calendario calendario) {
        this.calendario = calendario;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Emocoes getEmocao() {
        return emocao;
    }

    public void setEmocao(Emocoes emocao) {
        this.emocao = emocao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
