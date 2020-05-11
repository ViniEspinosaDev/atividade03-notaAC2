package com.example.atividade03notaac2.repository;

import com.example.atividade03notaac2.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Integer> {
    
}