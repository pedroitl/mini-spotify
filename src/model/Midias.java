package model;

import enums.Genero;

public abstract class Midias {
    private String titulo;
    private String artista;
    private Double duracao;
    private Genero genero;

    public Midias(String titulo, String artista, Double duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }
}
