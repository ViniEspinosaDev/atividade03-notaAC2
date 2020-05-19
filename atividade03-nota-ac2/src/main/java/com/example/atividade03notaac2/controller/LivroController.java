package com.example.atividade03notaac2.controller;

import java.util.List;

import com.example.atividade03notaac2.entity.Autor;
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
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro) {

        livroService.salvar(livro);

        return "redirect:/livros";
    }

    @PostMapping("/associarAutorLivro")
    public String associarAutor(@ModelAttribute Autor autor, @RequestParam Integer idLivro) {
        

        Livro livro = livroService.getLivroById(idLivro);
        autor = autorService.getAutorById(autor.getIdAutor());
        

        livro.getAutores().add(autor);
        livroService.salvar(livro);

        return "redirect:/detalhesLivros/" + idLivro.toString();
    }

    @GetMapping("/detalhesLivro/{idLivro}")
    public ModelAndView getLivroDetalhes(@PathVariable(name = "idLivro") Integer idLivro) {

        Livro livro = livroService.getLivroById(idLivro);
        ModelAndView mv = new ModelAndView("detalhesLivro");

        mv.addObject("livro", livro);

        List <Autor> autoresNaoAssociados = autorService.getAutores();
        autoresNaoAssociados.removeAll(livro.getAutores());

        mv.addObject("autores", autoresNaoAssociados);

        return mv;
    }

}