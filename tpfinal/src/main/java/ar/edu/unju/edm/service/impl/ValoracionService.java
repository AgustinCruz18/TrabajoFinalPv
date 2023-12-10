package ar.edu.unju.edm.service.impl;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.model.ValoracionKey;
import ar.edu.unju.edm.repository.ValoracionRepository;
import ar.edu.unju.edm.service.IValoracionService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Service
public class ValoracionService implements IValoracionService {
    @Autowired
    ValoracionRepository valoracionRepository;

    public void addValoracion(Valoracion valoracion) {
        valoracionRepository.save(valoracion);
    }

    public Optional<Valoracion> getValoracion(ValoracionKey codigo) {
        return valoracionRepository.findById(codigo);
    }
}
