package model;

import enums.Genero;

public class Musica extends Midia {
    public Musica(String titulo, String artista, Integer duracao, Genero genero) {
        super(titulo, artista, genero, duracao);
    }

    @Override
    public void reproduzir() {
        System.out.println("Tocando agora: " + titulo + " - " + artista);
    }
}
