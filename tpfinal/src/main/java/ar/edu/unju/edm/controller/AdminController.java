package ar.edu.unju.edm.controller;

import ar.edu.unju.edm.TuristaDetails;
// import ar.edu.unju.edm.TuristaDetails;
import ar.edu.unju.edm.service.IPuntoService;
import ar.edu.unju.edm.service.ITuristaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    ITuristaService turistaService;

    @Autowired
    IPuntoService puntoService;

    @GetMapping("/admin")
    public String getAdmin(Model model, @AuthenticationPrincipal TuristaDetails details) {
        model.addAttribute("turistas", turistaService.getTurista());
        model.addAttribute("turistaActual", details.getTurista());
        model.addAttribute("puntos", puntoService.getPuntos());
        return "admin";
    }
}
