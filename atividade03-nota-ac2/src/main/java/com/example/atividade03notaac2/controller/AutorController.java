package com.example.atividade03notaac2.controller;

import com.example.atividade03notaac2.entity.Autor;
import com.example.atividade03notaac2.service.AutorService;
import com.example.atividade03notaac2.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/autores")
    public ModelAndView getAutores() {
        ModelAndView mv = new ModelAndView("autoresTemplate");

        mv.addObject("autor", new Autor());
        mv.addObject("autores", autorService.getAutores());

        return mv;
    }

    @GetMapping("/detalhesAutor/{id}")
    public ModelAndView getAutorDetalhes(@PathVariable(name = "id") Integer id) {

        Autor autor = autorService.getAutorById(id);
        ModelAndView mv = new ModelAndView("detalhesAutor");

        mv.addObject("livros", livroService.getLivros());
        mv.addObject("autor", autor);

        return mv;
    }

    
    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor) {

        autorService.salvar(autor);

        return "redirect:/autores";
    }

    @PostMapping("/salvarLivroAutor")
    public String salvarLivroAutor(@ModelAttribute Autor autor) {

        //autorService.salvar(autor);

        return "redirect:/autores";
    }

}