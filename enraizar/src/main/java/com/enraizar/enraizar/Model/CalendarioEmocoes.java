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
    @Column(name = "observacao", length = 200)
    private String observacao;

    public CalendarioEmocoes() {
    }


}
