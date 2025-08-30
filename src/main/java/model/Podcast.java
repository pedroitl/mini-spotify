package main.java.model;

import main.java.enums.Genero;

public class Podcast extends Midia {
    public Podcast(String titulo, String artista, Integer duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    @Override
    public void reproduzir() {
        System.out.println("Podcast: " + titulo + " - " + artista + " | " + duracao);
    }
}
