package com.example.atividade03notaac2.repository;

import com.example.atividade03notaac2.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor,Integer> {
    
}