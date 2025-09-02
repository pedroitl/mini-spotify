import model.Midia;
import model.Playlist;
import model.Usuarios;
import service.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.EntradaVaziaException;
import exceptions.ListaVaziaException;
import exceptions.OpcaoInvalidaException;


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
        System.out.println("Usuário " + nome + " cadastrado com sucesso!");
    }

    private Usuarios buscarUsuario(String nome) {
        for (Usuarios u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null;
    }

    public void iniciar() throws EntradaVaziaException, OpcaoInvalidaException, ListaVaziaException {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Criar Usuário");
            System.out.println("2 - Adicionar Mídia ao Catálogo");
            System.out.println("3 - Remover Mídia do Catálogo");
            System.out.println("4 - Buscar Mídia (título/gênero/artista)");
            System.out.println("5 - Exibir Todas as Mídias");
            System.out.println("6 - Criar Playlist");
            System.out.println("7 - Remover Playlist");
            System.out.println("8 - Acessar Playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    cadastrarUsuario(nome, email);
                    break;

                case 2:
                    catalogo.adicionarMidia(sc);
                    System.out.println("Mídia adicionada ao catálogo!");
                    break;

                case 3:
                    catalogo.removerMidia(sc);
                    break;

                case 4:
                    catalogo.buscarMidia(sc);
                    break;

                case 5:
                	catalogo.exibirTodas();
                    break;

                case 6:
                	try {
                	if (usuarios.size()==0) {
                    	throw new ListaVaziaException("Não há usuários cadastrados");
                    }
                    System.out.print("Nome do usuário: ");
                    String usuarioNome = sc.nextLine();
                    Usuarios dono = buscarUsuario(usuarioNome);

                    if (dono != null) {
                        System.out.print("Nome da playlist: ");
                        String nomePlaylist = sc.nextLine();
                        if(nomePlaylist.trim().isEmpty()){
                        	throw new EntradaVaziaException("O nome da playlist não pode ser vazio");
                        }
                            dono.criarPlaylist(nomePlaylist);
                    }else {
                        System.out.println("Usuário não encontrado.");
                    }
                    } catch (EntradaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;

                case 7:
                	try {
                	if (usuarios.size()==0) {
                    	throw new ListaVaziaException("Não há usuários cadastrados");
                    }
                    System.out.print("Nome do usuário: ");
                    String usuarioRemover = sc.nextLine();
                    Usuarios u2 = buscarUsuario(usuarioRemover);
                    
                    
                    if (u2 != null) {
                    	if (u2.getPlaylists().isEmpty()) {
                        	throw new ListaVaziaException("Não há playlists");
                        }
                        System.out.print("Nome da playlist a remover: ");
                        String plNome = sc.nextLine();
                        u2.removerPlaylist(plNome);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    }catch(ListaVaziaException e) {
                    	System.out.println(e.getMessage());
                    	
                    }
                    break;

                case 8:
                	try {
                	if (usuarios.size()==0) {
                    	throw new ListaVaziaException("Não há usuários cadastrados");
                    }
                    System.out.print("Nome do usuário: ");
                    String usuarioPlay = sc.nextLine();
                    Usuarios u1 = buscarUsuario(usuarioPlay);
                    
                    if (u1 != null) {
                    	if (u1.getPlaylists().isEmpty()) {
                        	throw new ListaVaziaException("Não há playlists");
                        }
                        System.out.print("Nome da playlist: ");
                        String nomePl = sc.nextLine();
                        Playlist playlist = null;
                        for (Playlist p : u1.getPlaylists()) {
                            if (p.getNome().equalsIgnoreCase(nomePl)) {
                                playlist = p;
                                break;
                            }
                        }

                        if (playlist != null) {
                            int opPl;
                            do {
                                System.out.println("\n--- Playlist: " + nomePl + " ---");
                                System.out.println("1 - Adicionar Mídia");
                                System.out.println("2 - Remover Mídia");
                                System.out.println("3 - Visualizar Mídias");
                                System.out.println("4 - Exibir Duração Total");
                                System.out.println("0 - Voltar");
                                opPl = sc.nextInt();
                                sc.nextLine();

                                switch (opPl) {
                                    case 1:
                                        Midia mAdd = catalogo.buscarTitulo(sc);
                                        if (mAdd != null) {
                                            playlist.adicionarMidia(mAdd);
                                        } else {
                                            System.out.println("Mídia não encontrada no catálogo.");
                                        }
                                        break;

                                    case 2:
                                    	if(playlist.getMidias().isEmpty()) {
                                    		throw new ListaVaziaException("Não há midias cadastradas na playlist!");
                                    	}
                                        System.out.print("Título da mídia para remover: ");
                                        String midiaRem = sc.nextLine();
                                            playlist.removerMidia(midiaRem);
                                        break;

                                    case 3:
                                    	if(playlist.getMidias().isEmpty()) {
                                    		throw new ListaVaziaException("Não há midias cadastradas na playlist!");
                                    	}
                                            playlist.visualizarMidias();
                                        break;

                                    case 4:
                                        System.out.println("Duração total: " + playlist.duracaoTotal() + " min");
                                        break;
                                }
                            } while (opPl != 0);
                        } else {
                        	System.out.println("Playlist não encontrada.");
                        }
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                	}catch(ListaVaziaException e){
                    	System.out.println(e.getMessage());
                    }catch (OpcaoInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                	break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}