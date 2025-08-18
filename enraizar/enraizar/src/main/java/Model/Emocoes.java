package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "emocoes")
public class Emocoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descrisao", length = 50, nullable = false)
    private String descrisao;
    @Column (name = "valor", length = 11, nullable = false)
    private int valor;

    public Emocoes() {
    }

    public Emocoes(int id, String descrisao, int valor) {
        this.id = id;
        this.descrisao = descrisao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
