package model;

import enums.Genero;

public class Audiobook extends Midia {
    public Audiobook(String titulo, String artista, Integer duracao, Genero genero) {
        super(titulo, artista, genero, duracao);
    }

    @Override
    public void reproduzir() {
        System.out.println("AudioBook: " + titulo + " - " + artista + " | " + duracao);
    }
}
