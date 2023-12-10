package ar.edu.unju.edm.controller;

// import ar.edu.unju.edm.TuristaDetails;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.service.ITuristaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;



@Controller
public class TuristaController {
    @Autowired
    ITuristaService turistaService;

    @GetMapping("/addTurista")
    public String postTurista(@RequestParam("turista_id") Optional<Integer> codigo, Model model) {
        var turista = codigo.map(turistaService::getTurista).orElse(Optional.of(new Turista()));
        model.addAttribute("turista", turista);
        return "addTurista.html";
    }

    @PostMapping("/addTurista")
    public String getTurista(@Valid Turista turista, BindingResult result) {
        if (result.hasErrors()) {
            return "addTurista";
        }
        // var bcrypt = new BCryptPasswordEncoder();
        var fTurista = turistaService.findTuristaByNombre(turista.getNombre());
        if (fTurista.isPresent()) {
            var fTuristaUnwrapped = fTurista.get();
            // fTuristaUnwrapped.setPassword(bcrypt.encode(turista.getPassword()));
            fTuristaUnwrapped.setRol(turista.getRol());
            fTuristaUnwrapped.setEstado(true);
            turistaService.addTurista(fTuristaUnwrapped);
        } else {
            // turista.setPassword(bcrypt.encode(turista.getPassword()));
            turista.setEstado(true);
            turistaService.addTurista(turista);
        }
        return "redirect:/admin";
    }

    @PostMapping("/deleteTurista")
    public String deleteTurista(@RequestParam("turista_id") Integer id) {
        turistaService.deleteTurista(id);
        return "redirect:/admin";
    }


    // @GetMapping("/turista")
    // public String getTurista(@RequestParam("turista_id") Optional<Integer> turistaId, Model model, @AuthenticationPrincipal TuristaDetails details) {
    //     var turista = turistaService.getTurista(turistaId.orElse(details.getTurista().getTuristaId())).orElseThrow();
    //     model.addAttribute("turista", turista);
    //     return "turista.html";
    // }

}
