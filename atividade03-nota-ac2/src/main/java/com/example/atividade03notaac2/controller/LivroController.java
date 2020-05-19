package com.example.atividade03notaac2.controller;

import com.example.atividade03notaac2.entity.Livro;
import com.example.atividade03notaac2.service.AutorService;
import com.example.atividade03notaac2.service.EditoraService;
import com.example.atividade03notaac2.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private EditoraService editoraService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/livros")
    public ModelAndView getLivros() {
        ModelAndView mv = new ModelAndView("livrosTemplate");

        mv.addObject("livro", new Livro());
        mv.addObject("editoras", editoraService.getEditoras());
        mv.addObject("livros", livroService.getLivros());

        return mv;
    }

    @GetMapping("/detalhesLivro/{id}")
    public ModelAndView getLivroDetalhes(@PathVariable(name = "id") Integer id) {

        Livro livro = livroService.getLivroById(id);
        ModelAndView mv = new ModelAndView("detalhesLivro");

        mv.addObject("autores", autorService.getAutores());
        mv.addObject("livro", livro);

        return mv;
    }
    
    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro) {

        livroService.salvar(livro);

        return "redirect:/livros";
    }

    @PostMapping("/salvarAutorLivro")
    public String salvarAutorLivro(@ModelAttribute Livro livro) {

        livroService.salvar(livro);

        return "redirect:/livros";
    }

}