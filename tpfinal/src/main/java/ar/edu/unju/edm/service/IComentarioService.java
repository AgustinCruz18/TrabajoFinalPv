package ar.edu.unju.edm.service;


import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Comentario;
import ar.edu.unju.edm.model.ComentarioKey;

import java.util.Optional;

@Service
public interface IComentarioService {
    void addComentario(Comentario comentario);

    Optional<Comentario> getComentario(ComentarioKey codigo);
    //public void deleteComentario(int codigo);
}
