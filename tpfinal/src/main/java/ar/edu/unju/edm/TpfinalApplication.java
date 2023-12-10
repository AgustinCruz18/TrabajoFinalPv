package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.service.impl.TuristaService;

@SpringBootApplication
public class TpfinalApplication implements CommandLineRunner {

    @Autowired
    private TuristaService service;

    public static void main(String[] args) {
        SpringApplication.run(TpfinalApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            Turista turista = new Turista(1, "Agustin", "1234", "ADMIN", true);
            service.addTurista(turista);
        } catch (Exception e) {
            // Handle exceptions (e.g., log them or print the stack trace)
            e.printStackTrace();
    	}
		}
	}