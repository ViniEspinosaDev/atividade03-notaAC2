package com.example.atividade03notaac2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
public class Autor implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_autor;

    private String nome;
    private String cpf;
    private String email;
    private String origem;

    @ManyToMany
    @JoinTable(name = "CursosProfessores", uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro",
            "id_autor" }), joinColumns = @JoinColumn(name = "id_autor"), inverseJoinColumns = @JoinColumn(name = "id_livro"))
    private List<Livro> livros;

    // #region Getters and Setters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    // #endregion
    
    // #region Override
    @Override
    public String toString() {
        return "Autor [cpf=" + cpf + ", email=" + email + ", id_autor=" + id_autor + ", livros=" + livros + ", nome="
                + nome + ", origem=" + origem + "]";
    }
    // #endregion

}