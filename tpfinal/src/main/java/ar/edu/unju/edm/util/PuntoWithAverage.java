package ar.edu.unju.edm.util;

import ar.edu.unju.edm.model.Punto;

public record PuntoWithAverage(Punto punto, Double average, Integer turistaRating) {
    public PuntoWithAverage(Punto punto, Double average) {
        this(punto, average, null);
    }
}
