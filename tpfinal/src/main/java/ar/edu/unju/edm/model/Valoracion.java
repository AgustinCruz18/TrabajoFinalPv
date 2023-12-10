package ar.edu.unju.edm.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "valoraciones")
public class Valoracion {
    @EmbeddedId
    public ValoracionKey id;

    @ManyToOne
    @MapsId("turistaId")
    @JoinColumn(name = "turista_id")
    public Turista turista;

    @ManyToOne
    @MapsId("puntoId")
    @JoinColumn(name = "punto_id")
    public Punto punto;

    @Max(value = 5, message = "debe ser menor o igual a 5")
    @Min(value = 1, message = "debe ser mayor o igual a 1")
    @NotNull(message = "debe especificar un rating")
    public Integer rating;

    public Valoracion(int rating) {
        this.rating = rating;
    }

    public Valoracion() {
        this.punto = new Punto();
        this.turista = new Turista();
        this.id = new ValoracionKey();
    }

    public ValoracionKey getId() {
        return id;
    }

    public void setId(ValoracionKey id) {
        this.id = id;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
