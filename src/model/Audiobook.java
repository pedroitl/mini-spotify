package model;

import enums.Genero;

public class Audiobook extends Midias{
    public Audiobook(String titulo, String artista, Double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    @Override
    public void reproduzir() {
        System.out.println("AudioBook: " + titulo + " - " + artista + " | " + duracao);
    }
}
