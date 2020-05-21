package com.example.atividade03notaac2.controller;

import com.example.atividade03notaac2.entity.Editora;
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
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/editoras")
    public ModelAndView getEditoras() {
        ModelAndView mv = new ModelAndView("editorasTemplate");

        mv.addObject("editora", new Editora());
        mv.addObject("editoras", editoraService.getEditoras());

        return mv;
    }

    @GetMapping("/detalhesEditora/{id}")
    public ModelAndView getEditoraDetalhes(@PathVariable(name = "id") Integer id) {

        Editora editora = editoraService.getEditoraById(id);
        ModelAndView mv = new ModelAndView("detalhesEditora");

        mv.addObject("editora", editora);

        return mv;
    }

    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora) {

        editoraService.salvar(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/removerEditora")
    public String removerEditora(@RequestParam Integer idEditora) {

        Editora editora = editoraService.getEditoraById(idEditora);
        editoraService.remover(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/editarEditora")
    public ModelAndView editarLivro(@ModelAttribute Editora editora, @RequestParam Integer idEditora) {

        ModelAndView mv = new ModelAndView("EditoraEdit");

        Editora editora1 = editoraService.getEditoraById(editora.getIdEditora());

        mv.addObject("livros", livroService.getLivros());
        mv.addObject("editora", editora1);

        return mv;
    }

}