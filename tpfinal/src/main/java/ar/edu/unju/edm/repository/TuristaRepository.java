package ar.edu.unju.edm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Turista;


@Repository
public interface TuristaRepository extends CrudRepository<Turista, Integer> {

    
    Optional<Turista> findTuristaByNombre(String nombre);
}
