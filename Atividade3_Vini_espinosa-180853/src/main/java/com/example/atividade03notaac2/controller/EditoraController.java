package com.example.atividade03notaac2.controller;

import com.example.atividade03notaac2.entity.Editora;
import com.example.atividade03notaac2.service.EditoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

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
}