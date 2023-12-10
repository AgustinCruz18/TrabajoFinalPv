package ar.edu.unju.edm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ar.edu.unju.edm.TuristaDetails;
import ar.edu.unju.edm.repository.TuristaRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TuristaRepository turistaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var turista = turistaRepository.findTuristaByNombre(username);
        System.out.println(turista);

        return new TuristaDetails(turista.orElseThrow(() -> new UsernameNotFoundException("no se encontró el nombre de usuario")));
    }
}
