package ar.edu.unju.edm.model;



import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name = "turistas")
public class Turista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turista_id")
    private int turistaId;

    @Override
    public String toString() {
        return "Turista{" +
                "turistaId=" + turistaId +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Column(unique = true)
    @NotNull(message = "debe especificar un nombre")
    @NotBlank(message = "no debe estar en blanco")
    private String nombre;

    @NotNull(message = "debe especificar una contraseña")
    @NotBlank(message = "no debe estar en blanco")
    private String password;

    @NotBlank(message = "debe especificar un rol")
    private String rol;

    private boolean estado;

    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private List<Punto> puntos;


    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "turista", cascade = CascadeType.REMOVE)
    private Set<Valoracion> valoraciones;



    public Turista(int turistaId,
            @NotNull(message = "debe especificar un nombre") @NotBlank(message = "no debe estar en blanco") String nombre,
            @NotNull(message = "debe especificar una contraseña") @NotBlank(message = "no debe estar en blanco") String password,
            @NotBlank(message = "debe especificar un rol") String rol, boolean estado) {
        this.turistaId = turistaId;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public Turista() {
    }

    public Turista(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public int getTuristaId() {
        return turistaId;
    }

    public void setTuristaId(int turistaId) {
        this.turistaId = turistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(Set<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
}
