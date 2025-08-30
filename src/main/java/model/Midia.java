package main.java.model;

import main.java.enums.Genero;

public abstract class Midia {
    protected String titulo;
    protected String artista;
    protected Genero genero;
    protected Integer duracao;

    public Midia(String titulo, String artista, Genero genero, Integer duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return titulo +" - " +artista+" | " + "\n" + duracao + " " + genero;
    }

    public abstract void reproduzir();
}