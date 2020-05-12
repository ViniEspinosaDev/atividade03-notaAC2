package com.example.atividade03notaac2.service;

import java.util.List;

import com.example.atividade03notaac2.entity.Livro;
import com.example.atividade03notaac2.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public void salvar(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro getLivroById(int id) {
        return livroRepository.findById(id).get();
    }
}