package com.example.atividade03notaac2.service;

import java.util.List;

import com.example.atividade03notaac2.entity.Editora;
import com.example.atividade03notaac2.repository.EditoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> getEditoras() {
        return editoraRepository.findAll();
    }

    public void salvar(Editora editora) {
        editoraRepository.save(editora);
    }
}