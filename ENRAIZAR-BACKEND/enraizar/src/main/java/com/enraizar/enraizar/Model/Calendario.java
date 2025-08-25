package com.enraizar.enraizar.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

// Entidade JPA para registros de Calendário
@Entity
@Table(name = "calendarios")
public class Calendario {
    // Identificador do registro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Identificador do usuário dono do registro
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    // Data do registro
    @Column(name = "data", nullable = false)
    private LocalDate data;

    // Retorna o ID
    public Integer getId() { return id; }
    // Define o ID
    public void setId(Integer id) { this.id = id; }

    // Retorna o ID do usuário
    public Integer getIdUsuario() { return idUsuario; }
    // Define o ID do usuário
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    // Retorna a data
    public LocalDate getData() { return data; }
    // Define a data
    public void setData(LocalDate data) { this.data = data; }
}
