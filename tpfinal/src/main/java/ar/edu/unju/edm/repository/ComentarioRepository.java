package ar.edu.unju.edm.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Comentario;
import ar.edu.unju.edm.model.ComentarioKey;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, ComentarioKey> {
}
