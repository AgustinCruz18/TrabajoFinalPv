package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Punto;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.util.PuntoWithAverage;

import java.util.Optional;
import java.util.List;

@Service
public interface IPuntoService {
    void addPunto(Punto punto);

    Optional<Punto> getPunto(int codigo);

    void deletePunto(int codigo);

    List<Punto> getPuntos();

    List<PuntoWithAverage> getPuntosWithAverage(Turista turista);
    List<PuntoWithAverage> getPuntosWithAverage();
}
