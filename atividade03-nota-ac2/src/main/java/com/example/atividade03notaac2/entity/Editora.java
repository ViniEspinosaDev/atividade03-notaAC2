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
    private int idEditora;

    private String nome;
    private String origem;
    private int anoInauguracao;
    private String endereco;

    @OneToMany
    @JoinColumn(name = "idEditora")
    private List<Livro> livros;

    // #region Getters and Setters

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

    public int getAnoInauguracao() {
        return anoInauguracao;
    }

    public void setAnoInauguracao(int anoInauguracao) {
        this.anoInauguracao = anoInauguracao;
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
        return "Editora [endereco=" + endereco + ", idEditora=" + idEditora + ", anoInauguracao=" + anoInauguracao
                + ", livros=" + livros + ", nome=" + nome + ", origem=" + origem + "]";
    }
    // #endregion

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

}