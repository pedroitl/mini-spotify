import model.Usuarios;
import service.Catalogo;

import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private List<Usuarios> usuarios;
    private Catalogo catalogo;

    // Construtor
    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.catalogo = new Catalogo();
    }

    // Cadastrar usuário no sistema
    public void cadastrarUsuario(String nome, String email) {
        Usuarios usuario = new Usuarios(nome, email);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + nome);
    }

    // Iniciar o sistema (simulação)
    public void iniciar() {
        System.out.println("Sistema iniciado!");
        System.out.println("Número de usuários cadastrados: " + usuarios.size());
        System.out.println("Quantidade de mídias no catálogo: " + catalogo.getQtdMidias());
    }

    // Métodos auxiliares (se quiser acessar dados depois)
    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}