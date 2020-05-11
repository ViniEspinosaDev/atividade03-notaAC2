package com.example.atividade03notaac2.service;

import java.util.List;

import com.example.atividade03notaac2.entity.Autor;
import com.example.atividade03notaac2.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    public void salvar(Autor autor) {
        autorRepository.save(autor);
    }
}