package Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="usuarios")
public class Funcionario {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login_email", length = 50, nullable = false)
    private String loginEmail;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "CPF", length = 11, nullable = false)
    private String CPF;

    @Column(name = "id_setor", length = 11, nullable = false)
    private int idSetor;

    @Column(name = "tipo_usuario", length = 40, nullable = false)
    private String tipoUser;

    @Column(name = "createat", nullable = false)
    private LocalDate createAt;

    @Column(name = "updateat", nullable = false)
    private LocalDate updateAt;

    @Column(name = "email", length = 50, nullable = false)
    private String Email;

    public Funcionario() {
    }

    public Funcionario(int id, String loginEmail, String senha, String nome, String sobrenome, LocalDate dataNascimento, String CPF, int idSetor, String tipoUser, LocalDate createAt, LocalDate updateAt, String email) {
        this.id = id;
        this.loginEmail = loginEmail;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.CPF = CPF;
        this.idSetor = idSetor;
        this.tipoUser = tipoUser;
        this.createAt = createAt;
        this.updateAt = updateAt;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
