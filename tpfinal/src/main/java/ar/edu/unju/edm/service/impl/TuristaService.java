package ar.edu.unju.edm.service.impl;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.TuristaRepository;
import ar.edu.unju.edm.service.ITuristaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.List;


@Service
public class TuristaService implements ITuristaService {
    @Autowired
    TuristaRepository turistaRepository;

    public void addTurista(Turista turista) {
         String password = turista.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        turista.setPassword(encoder.encode(password));
        turistaRepository.save(turista);
    }

    public Optional<Turista> getTurista(int codigo) {
        return turistaRepository.findById(codigo);
    }

    public void deleteTurista(int codigo) {
        turistaRepository.deleteById(codigo);
    }

    public List<Turista> getTurista() {
        return (List<Turista>) turistaRepository.findAll();
    }

    @Override
    public Optional<Turista> findTuristaByNombre(String nombre) {
        return turistaRepository.findTuristaByNombre(nombre);
    }
}
