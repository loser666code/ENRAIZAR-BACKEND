package com.enraizar.enraizar.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// Entidade JPA para a relação Calendário-Emoção (chave composta)
@Entity
@Table(name = "calendario_emocoes")
@IdClass(CalendarioEmocao.CalendarioEmocaoId.class)
public class CalendarioEmocao {
    // Parte da chave composta: id do calendário
    @Id
    @Column(name = "id_calendario")
    private Integer idCalendario;

    // Parte da chave composta: id da emoção
    @Id
    @Column(name = "id_emocao")
    private Integer idEmocao;

    // Observação opcional
    @Column(name = "observacao")
    private String observacao;

    // Classe de ID composta
    public static class CalendarioEmocaoId implements Serializable {
        // serialVersionUID para evitar warning de serialização
        private static final long serialVersionUID = 1L;

        // Campos da chave
        private Integer idCalendario;
        private Integer idEmocao;

        // Construtor padrão
        public CalendarioEmocaoId() { }

        // Construtor completo
        public CalendarioEmocaoId(Integer idCalendario, Integer idEmocao) {
            this.idCalendario = idCalendario;
            this.idEmocao = idEmocao;
        }

        // Igualdade por campos
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CalendarioEmocaoId that = (CalendarioEmocaoId) o;
            return Objects.equals(idCalendario, that.idCalendario) &&
                   Objects.equals(idEmocao, that.idEmocao);
        }

        // Hash por campos
        @Override
        public int hashCode() {
            return Objects.hash(idCalendario, idEmocao);
        }
    }

    // Retorna idCalendario
    public Integer getIdCalendario() { return idCalendario; }
    // Define idCalendario
    public void setIdCalendario(Integer idCalendario) { this.idCalendario = idCalendario; }

    // Retorna idEmocao
    public Integer getIdEmocao() { return idEmocao; }
    // Define idEmocao
    public void setIdEmocao(Integer idEmocao) { this.idEmocao = idEmocao; }

    // Retorna observacao
    public String getObservacao() { return observacao; }
    // Define observacao
    public void setObservacao(String observacao) { this.observacao = observacao; }
}
