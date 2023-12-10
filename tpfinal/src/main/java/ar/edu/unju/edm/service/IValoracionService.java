package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.model.ValoracionKey;

import java.util.Optional;

@Service
public interface IValoracionService {
    void addValoracion(Valoracion valoracion);

    Optional<Valoracion> getValoracion(ValoracionKey codigo);
}
