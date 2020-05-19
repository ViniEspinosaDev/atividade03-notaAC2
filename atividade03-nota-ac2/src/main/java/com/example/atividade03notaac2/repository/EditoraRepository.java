package com.example.atividade03notaac2.repository;

import com.example.atividade03notaac2.entity.Editora;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository <Editora, Integer> {
    
}