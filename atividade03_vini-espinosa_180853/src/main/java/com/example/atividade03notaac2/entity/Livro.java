package com.example.atividade03notaac2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
public class Livro implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_livro;

    private String nome;
    private String genero;
    private double preco;
    private String ano;

    @ManyToMany
    @JoinTable(name = "CursosProfessores", uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro",
            "id_autor" }), joinColumns = @JoinColumn(name = "id_livro"), inverseJoinColumns = @JoinColumn(name = "id_autor"))
    private List<Autor> autores;

    @OneToMany
    @JoinColumn(name = "ID_LIVRO")
    private Editora editora;

    // #region Getters and Setters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    // #endregion

    // #region Override
    @Override
    public String toString() {
        return "Livro [ano=" + ano + ", autores=" + autores + ", editora=" + editora + ", genero=" + genero
                + ", id_livro=" + id_livro + ", nome=" + nome + ", preco=" + preco + "]";
    }
    // #endregion

}