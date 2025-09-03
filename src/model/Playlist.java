package model;

import exceptions.EntradaVaziaException;
import exceptions.ListaVaziaException;
import exceptions.OpcaoInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private Usuarios dono;
    private List<Midia> midias;

    public Playlist(String nome, Usuarios dono) throws EntradaVaziaException {
        if (nome == null || nome.isBlank()) {
            throw new EntradaVaziaException("Nome da playlist não pode ser nulo ou vazio!");
        }
        if (dono == null) {
            throw new EntradaVaziaException("A playlist precisa de um dono!");
        }

        this.nome = nome;
        this.dono = dono;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Usuarios getDono() {
        return dono;
    }

    public List<Midia> getMidias() {
        return new ArrayList<>(midias);
    }

    public void adicionarMidia(ArrayList<Midia> mAdd) {
        midias.addAll(mAdd);
        System.out.println("Mídia adicionada!");
    }

    public void removerMidia(String titulo) throws OpcaoInvalidaException {
        boolean removida = midias.removeIf(m -> m.getTitulo().equalsIgnoreCase(titulo));
        if (!removida) {
            throw new OpcaoInvalidaException("Mídia não encontrada: " + titulo);
        }
        System.out.println("Mídia removida: " + titulo);
    }

    public void visualizarMidias() throws ListaVaziaException {
        System.out.println("\nPlaylist: " + nome + " | Dono: " + dono.getNome());
        if (midias.isEmpty()) {
            throw new ListaVaziaException("A playlist está vazia.");
        }
        for (Midia m : midias) {
            System.out.println("- " + m);
        }
    }

    public int duracaoTotal() {
        int total = 0;
        for (Midia m : midias) {
            total += m.getDuracao();
        }
        return total;
    }
}
