/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.leonrv3.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.leonrv3.domain.Libro;
import mx.com.leonrv3.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author L
 */
@Controller
@Slf4j
public class ControladorLibro {
    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ejecutando el controlador spring mustacho mvc");

        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);

        return "index";
    }

    // VISTA
    @GetMapping("/agregar")
    public String agregar(Libro libro) {

        return "agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Libro libro) {

        // Inferencia sobre si el libro ya cuenta con Id para agregar o modificar
        libroService.guardar(libro);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Libro libro, Model model) {
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Libro libro) {
        libroService.eliminar(libro);
        return "redirect:/";
    }

}
