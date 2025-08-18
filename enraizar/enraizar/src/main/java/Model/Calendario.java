package Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "calendario")
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_usuario",length = 11,nullable = false)
    private String idUsuario;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "time", nullable = false)
    private Time time;

    public Calendario() {
    }

    public Calendario(int id, String idUsuario, LocalDate data, Time time) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.data = data;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
