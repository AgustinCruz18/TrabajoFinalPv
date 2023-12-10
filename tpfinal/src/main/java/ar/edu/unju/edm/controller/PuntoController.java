package ar.edu.unju.edm.controller;

import ar.edu.unju.edm.TuristaDetails;
import ar.edu.unju.edm.model.Punto;
import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.service.IPuntoService;
import ar.edu.unju.edm.service.ITuristaService;
import ar.edu.unju.edm.service.IValoracionService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Objects;
import java.util.Optional;



@Controller
public class PuntoController {
    @Autowired
    IPuntoService puntoService;
    @Autowired
    IValoracionService valoracionService;
    @Autowired
    ITuristaService turistaService;


    @GetMapping("/addPunto")
    public String getPuntoDeInteres(@RequestParam("punto_id") Optional<Integer> codigo, Model model, @AuthenticationPrincipal TuristaDetails details) {
        Objects.requireNonNull(details);
        var punto = codigo.flatMap(puntoService::getPunto).orElse(new Punto());
        if (Objects.isNull(punto.getTurista())) {
            var turista = turistaService.getTurista(details.getTurista().getTuristaId()).orElseThrow();
            punto.setTurista(turista);
            turista.getPuntos().add(punto);
        }
        model.addAttribute("punto", punto);
        return "addPunto.html";
    }

    @PostMapping(value = "/addPunto", consumes = "multipart/form-data")
    public String postPuntoDeInteres(@Valid Punto punto, BindingResult result, @RequestParam("file") MultipartFile[] archivo, Model model, @AuthenticationPrincipal TuristaDetails details) {
        Objects.requireNonNull(details);
        assert punto.getTurista().getTuristaId() == details.getTurista().getTuristaId();
        if (result.hasErrors()) {
            return "addPunto";
        }

        try {
            byte[] contenido = archivo[0].getBytes();
            String base64 = Base64.getEncoder().encodeToString(contenido);
            punto.setImagenUrl("data:" + archivo[0].getContentType() + ";base64," + base64);
        } catch (Exception e) {
            model.addAttribute("subirPuntoErrorMessage", e.getMessage());
        }

        puntoService.addPunto(punto);
        return "redirect:/puntos";
    }

    @GetMapping({"/", "/puntos"})
    public String getPuntos(Model model, @AuthenticationPrincipal TuristaDetails userDetails) {
        var turista = Optional.ofNullable(userDetails)
                .flatMap(t -> turistaService.getTurista(t.getTurista().getTuristaId()))
                .orElse(null);
        var puntos = puntoService.getPuntosWithAverage(turista);
        model.addAttribute("turista", turista);
        model.addAttribute("puntos", puntos);
        model.addAttribute("valoracion", new Valoracion());
        return "puntos.html";
    }

    @PostMapping("/deletePunto")
    public String deletePunto(@RequestParam("punto_id") Integer codigo) {
        puntoService.deletePunto(codigo);
        return "redirect:/puntos";
    }

    @GetMapping("/comentarios")
    public String getComentarios(@RequestParam("puntoId") Integer puntoId, Model model) {
        var punto = puntoService.getPunto(puntoId).orElse(new Punto());
        model.addAttribute("punto", punto);
        return "comentarios.html";
    }

    @PostMapping("/addValoracion")
    public String postValoracion(@RequestParam("puntoId") Integer puntoId,
                                 @ModelAttribute("valoracion") Valoracion valoracion,
                                 @AuthenticationPrincipal TuristaDetails details) {
        Objects.requireNonNull(details);
        assert valoracion.getTurista().getTuristaId() == details.getTurista().getTuristaId();
        var punto = puntoService.getPunto(puntoId).orElse(new Punto());
        var turista = turistaService.getTurista(details.getTurista().getTuristaId()).orElseThrow();
        valoracion.setPunto(punto);
        valoracion.setTurista(turista);
        valoracionService.addValoracion(valoracion);
        return "redirect:/puntos";
    }
}
