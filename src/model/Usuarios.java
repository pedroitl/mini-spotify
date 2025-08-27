package model;


import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String nome;
    private String email;
    private List<Playlist> playlists;

    public Usuarios(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public void criarPlaylist(String nomePlaylist) {
        Playlist nova = new Playlist(nomePlaylist, this);
        playlists.add(nova);
    }

    public void visualizarPlaylist() {
        for (Playlist p : playlists) {
            System.out.println(p.getNome());
        }
    }

    public void removerPlaylist(String nomePlaylist){
        playlists.removeIf(playlist -> playlist.getNome().equals(nomePlaylist));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
