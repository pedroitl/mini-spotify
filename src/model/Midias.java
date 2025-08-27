package model;

import enums.Genero;

public abstract class Midias {
    protected String titulo;
    protected String artista;
    protected Integer duracao;
    protected Genero genero;

    public Midias(String titulo, String artista, Integer duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }



    public void exibirInfo() {
        System.out.println(titulo + " - " + artista + " | " + "\n" + duracao + " " + genero);
    }

    public abstract void reproduzir();
}
