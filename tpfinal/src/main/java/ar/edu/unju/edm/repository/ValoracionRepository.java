package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.model.ValoracionKey;

@Repository
public interface ValoracionRepository extends CrudRepository<Valoracion, ValoracionKey> {
}
