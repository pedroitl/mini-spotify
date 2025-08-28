package model;


import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String nome;
    private String email;
    private List<Playlist> playlists;

    public Usuarios(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo!");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo!");
        }

        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public void criarPlaylist(String nomePlaylist) {
        if (nomePlaylist == null || nomePlaylist.isBlank()) {
            throw new IllegalArgumentException("Nome da playlist não pode ser nulo ou vazio");
        }

        for (Playlist p : playlists) {
            if (p.getNome() != null && p.getNome().equalsIgnoreCase(nomePlaylist)) {
                System.out.println("Já existe uma playlist com esse nome!");
                return;
            }
        }

        Playlist nova = new Playlist(nomePlaylist, this);
        playlists.add(nova);
        System.out.println("Playlist " + nomePlaylist + " Criada com sucesso!");
    }

    public void visualizarPlaylist() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist encontrada!");
        } else {
            for (Playlist p : playlists) {
                System.out.println(p.getNome());
            }
        }
    }

    public boolean removerPlaylist(String nomePlaylist) {
        return playlists.removeIf(playlist -> playlist.getNome() != null && playlist.getNome().equals(nomePlaylist));
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


}
