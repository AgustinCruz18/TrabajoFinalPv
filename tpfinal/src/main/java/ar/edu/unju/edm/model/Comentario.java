package ar.edu.unju.edm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int comentarioId;

    @ManyToOne
    @JoinColumn(name = "turista_id")
    public Turista turista;

    @ManyToOne
    @JoinColumn(name = "punto_id")
    public Punto punto;

    @NotBlank(message = "no debe estar en blanco")
    public String titulo;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String descripcion;

    public Comentario() {
    }

    public Comentario(int comentarioId, Turista turista, Punto punto, String titulo, String descripcion) {
        this.comentarioId = comentarioId;
        this.turista = turista;
        this.punto = punto;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Comentario(String titulo, String descripcion) {
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
