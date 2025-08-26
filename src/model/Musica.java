package model;

import enums.Genero;

public class Musica extends Midias{
    public Musica(String titulo, String artista, Double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }
}
