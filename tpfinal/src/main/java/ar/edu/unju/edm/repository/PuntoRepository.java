package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.util.PuntoWithAverage;
import ar.edu.unju.edm.model.Punto;
import ar.edu.unju.edm.model.Turista;


@Repository
public interface PuntoRepository extends CrudRepository<Punto, Integer> {
    @Query("SELECT NEW ar.edu.unju.edm.util.PuntoWithAverage(p, AVG(v.rating)) " +
            "FROM Punto p LEFT JOIN p.valoraciones v GROUP BY p.puntoId ORDER BY AVG(v.rating) DESC")
    List<PuntoWithAverage> findAllWithAverage();

    @Query("SELECT NEW ar.edu.unju.edm.util.PuntoWithAverage(p, AVG(v1.rating), v2.rating) FROM Punto p " +
            "LEFT JOIN p.valoraciones v1 " +
            "LEFT JOIN p.valoraciones v2 ON v2.turista = ?1 " +
            "GROUP BY p.puntoId ORDER BY AVG(v1.rating) DESC")
    List<PuntoWithAverage> findAllWithAverageAndUserRating(Turista turista);
}
