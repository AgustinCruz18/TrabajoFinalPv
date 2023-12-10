package ar.edu.unju.edm.service.impl;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Punto;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.PuntoRepository;
import ar.edu.unju.edm.service.IPuntoService;
import ar.edu.unju.edm.util.PuntoWithAverage;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;
import java.util.List;


@Service
public class PuntoService implements IPuntoService {
    @Autowired
    PuntoRepository puntoRepository;

    public void addPunto(Punto punto) {
        puntoRepository.save(punto);
    }

    public Optional<Punto> getPunto(int codigo) {
        return puntoRepository.findById(codigo);
    }

    public void deletePunto(int codigo) {
        puntoRepository.deleteById(codigo);
    }

    public List<Punto> getPuntos() {
        return (List<Punto>) puntoRepository.findAll();
    }

    @Override
    public List<PuntoWithAverage> getPuntosWithAverage(Turista turista) {
        if (!Objects.isNull(turista)) return  puntoRepository.findAllWithAverageAndUserRating(turista);
        return puntoRepository.findAllWithAverage();
    }

    @Override
    public List<PuntoWithAverage> getPuntosWithAverage() {
        return getPuntosWithAverage(null);
    }
}
