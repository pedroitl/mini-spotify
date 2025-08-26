package model;

import enums.Genero;

public class Podcast extends Midias{
    public Podcast(String titulo, String artista, Double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    @Override
    public void reproduzir() {
        System.out.println("Podcast: " + titulo + " - " + artista + " | " + duracao);
    }
}
