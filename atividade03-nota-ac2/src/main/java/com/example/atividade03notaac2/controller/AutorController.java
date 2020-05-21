package com.example.atividade03notaac2.controller;

import java.util.List;

import com.example.atividade03notaac2.entity.Autor;
import com.example.atividade03notaac2.entity.Livro;
import com.example.atividade03notaac2.service.AutorService;
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

    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor) {

        autorService.salvar(autor);

        return "redirect:/autores";
    }

    @PostMapping("/associarLivroAutor")
    public String associarLivro(@ModelAttribute Livro livro, @RequestParam Integer idAutor) {
        

        Autor autor = autorService.getAutorById(idAutor);
        livro = livroService.getLivroById(livro.getIdLivro());
        

        autor.getLivros().add(livro);
        autorService.salvar(autor);

        return "redirect:/detalhesAutor/" + idAutor.toString();
    }

    @GetMapping("/detalhesAutor/{idAutor}")
    public ModelAndView getAutorDetalhes(@PathVariable(name = "idAutor") Integer idAutor) {

        Autor autor = autorService.getAutorById(idAutor);
        ModelAndView mv = new ModelAndView("detalhesAutor");

        mv.addObject("autor", autor);

        List <Livro> livrosNaoAssociados = livroService.getLivros();
        livrosNaoAssociados.removeAll(autor.getLivros());

        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }

    @GetMapping("/removerAutor")
    public String removerAutor(@RequestParam Integer idAutor) {

        Autor autor = autorService.getAutorById(idAutor);
        autorService.remover(autor);

        return "redirect:/autores";
    }

    @GetMapping("/editarAutor")
    public ModelAndView editarAutor(@ModelAttribute Autor autor) {

        ModelAndView mv = new ModelAndView("autorEdit");

        Autor auxAutor = autorService.getAutorById(autor.getIdAutor());

        mv.addObject("autor", auxAutor);

        return mv;
    }

}