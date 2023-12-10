package ar.edu.unju.edm.service.impl;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Comentario;
import ar.edu.unju.edm.model.ComentarioKey;
import ar.edu.unju.edm.repository.ComentarioRepository;
import ar.edu.unju.edm.service.IComentarioService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Service
public class ComentarioService implements IComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;

    public void addComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public Optional<Comentario> getComentario(ComentarioKey codigo) {
        return comentarioRepository.findById(codigo);
    }

}
