package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private Usuarios dono;
    private List<Midias> midias;

    public Playlist(String nome, Usuarios dono) {
        this.nome = nome;
        this.dono = dono;
    }

    public Playlist(String nome, Usuarios dono, List<Midias> midias) {
        this.nome = nome;
        this.dono = dono;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuarios getDono() {
        return dono;
    }

    public void setDono(Usuarios dono) {
        this.dono = dono;
    }

    public List<Midias> getMidias() {
        return midias;
    }

    public void setMidias(List<Midias> midias) {
        this.midias = midias;
    }
}
