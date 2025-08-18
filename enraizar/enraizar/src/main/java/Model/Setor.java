package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "setores")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSetor;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao",length = 200,nullable = false)
    private String descricao;

    public Setor() {
    }

    public Setor(int idSetor, String nome, String descricao) {
        this.idSetor = idSetor;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
