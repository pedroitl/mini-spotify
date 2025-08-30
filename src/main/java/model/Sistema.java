package main.java.model;

import main.java.exceptions.EntradaVaziaException;
import main.java.service.Catalogo;

import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private List<Usuarios> usuarios;
    private Catalogo catalogo;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.catalogo = new Catalogo();
    }

    public void cadastrarUsuario(String nome, String email) throws EntradaVaziaException {
        Usuarios usuario = new Usuarios(nome, email);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + nome);
    }

    public void iniciar() {
        System.out.println("main.java.model.Sistema iniciado!");
        System.out.println("Número de usuários cadastrados: " + usuarios.size());
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}