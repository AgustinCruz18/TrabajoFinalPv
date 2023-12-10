package ar.edu.unju.edm.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "puntos")
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int puntoId;

    @NotNull(message = "debe especificar un nombre")
    @Size(min = 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String nombre;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "turista_id")//, nullable=false)
    private Turista turista;

    @OneToMany(mappedBy = "punto", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "punto", cascade = CascadeType.REMOVE)
    private List<Valoracion> valoraciones;

    public Punto() {
    }

    public Punto(@NotNull String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "puntoId=" + puntoId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';
    }

    public int getPuntoId() {
        return puntoId;
    }

    public void setPuntoId(int puntoId) {
        this.puntoId = puntoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
}
