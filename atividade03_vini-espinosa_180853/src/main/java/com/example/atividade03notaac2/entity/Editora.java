package com.example.atividade03notaac2.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Editora implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_editora;

    private String nome;
    private String origem;
    private String inauguracao;
    private String endereco;

    @OneToMany
    @JoinColumn(name = "ID_LIVRO")
    private List<Livro> livros;

    // #region Getters and Setters
    public int getId_editora() {
        return id_editora;
    }

    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getInauguracao() {
        return inauguracao;
    }

    public void setInauguracao(String inauguracao) {
        this.inauguracao = inauguracao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        return "Editora [endereco=" + endereco + ", id_editora=" + id_editora + ", inauguracao=" + inauguracao
                + ", livros=" + livros + ", nome=" + nome + ", origem=" + origem + "]";
    }
    // #endregion

}