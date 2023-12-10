package ar.edu.unju.edm.service;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Turista;

import java.util.Optional;
import java.util.List;

@Service
public interface ITuristaService {
    void addTurista(Turista turista);

    Optional<Turista> getTurista(int codigo);

    void deleteTurista(int codigo);

    List<Turista> getTurista();

    Optional<Turista> findTuristaByNombre(String nombre);
}
