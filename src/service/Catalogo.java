package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import enums.Genero;
import exceptions.EntradaVaziaException;
import exceptions.ListaVaziaException;
import exceptions.OpcaoInvalidaException;
import model.*;

public class Catalogo {
private ArrayList<Midia> midias = new ArrayList();
	
	public Midia buscarMidia(Scanner scanner) throws ListaVaziaException, EntradaVaziaException, OpcaoInvalidaException {
		Midia midia = null;
		if(midias.size()==0) {
			throw new ListaVaziaException("Não há midias cadastradas!");
		}
			try {
				midia = menuMidia(scanner);
			}catch(ListaVaziaException e) {
				System.out.println(e.getMessage());
			}catch(EntradaVaziaException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("O campo só aceita valores numericos e inteiros!");
			}catch(OpcaoInvalidaException e) {
				System.out.println(e.getMessage());
			}
			if(midia!=null) {
				return midia;
			}
			return null;

	}

	public Midia buscarTitulo(Scanner scanner) throws EntradaVaziaException {
		System.out.println("Digite o nome da midia que você procura");
		String midia = scanner.nextLine();
		if(midia.trim().isEmpty()) {
			throw new EntradaVaziaException("A entrada não pode ser vazia!");
		}
		for (int indice =0; indice<midias.size();indice++) {
			if(midias.get(indice).getTitulo().trim().equalsIgnoreCase(midia)) {
				System.out.println(midias.get(indice));
				return midias.get(indice);
			}
		}
		System.out.println("Não há midias com esse titulo");
		return null;
	}
	private Midia buscarGenero(Scanner scanner) throws EntradaVaziaException {
			System.out.println("Digite o nome do genero que você procura");
			String genero = scanner.nextLine().toUpperCase();
			if(genero.trim().isEmpty()) {
				throw new EntradaVaziaException("A entrada não pode ser vazia!");
			}
			for (int indice = 0; indice<midias.size();indice++) {
				switch (genero) {
				case "ROCK":
					if(midias.get(indice).getGenero() == Genero.ROCK) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				case "FORRO":
					if(midias.get(indice).getGenero() == Genero.FORRO) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				case "POP":
					if(midias.get(indice).getGenero() == Genero.POP) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				case "PAGODE":
					if(midias.get(indice).getGenero() == Genero.PAGODE) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				case "FUNK":
					if(midias.get(indice).getGenero() == Genero.FUNK) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				case "CLASSICA":
					if(midias.get(indice).getGenero() == Genero.CLASSICA) {
						System.out.println(midias.get(indice));
					}else {
						System.out.println("Nenhuma midia cadastrada!");
					}
					break;
				default:
					System.out.println("Genero não encontrado!");
				return midias.get(indice);
				}
				
			}
			return null;
	}
	private Midia buscarArtista(Scanner scanner) throws ListaVaziaException,EntradaVaziaException {
			System.out.println("Digite o nome do artista que você procura");
			String artista = scanner.nextLine();
			if(artista.trim().isEmpty()) {
				throw new EntradaVaziaException("A entrada não pode ser vazia!");
			}
			for (int indice = 0; indice< midias.size(); indice ++) {
				if(midias.get(indice).getArtista().trim().equalsIgnoreCase(artista)) {
					System.out.print(midias.get(indice));
					return midias.get(indice);
				}
			}
			System.out.println("Não há artistas com esse nome!");
			return null;
	}
	
	public void adicionarMidia(Scanner scanner) throws OpcaoInvalidaException, EntradaVaziaException {
		String titulo ="";
		String artista = "";
		int duracao=0;
		while(titulo.trim().isEmpty()) {
		try {
			System.out.println("Digite o nome da midia:");
			titulo = scanner.nextLine();
			if(titulo.trim().isEmpty()) {
				throw new EntradaVaziaException("O titulo não pode ser vazio");
			}else {
				System.out.println("Digite o nome do artista/autor:");
				artista = scanner.nextLine();
				System.out.println("Digite a duração da midia em minutos:");
				duracao = scanner.nextInt();
			}		
		menuMidia(scanner,titulo,artista,duracao);
		}catch(InputMismatchException e) {
			System.out.println("O campo só aceita valores numericos e inteiros!");
		}catch(EntradaVaziaException e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
	private void menuMidia(Scanner scanner,String titulo, String artista, int duracao) throws OpcaoInvalidaException {
		try {
			int opcao =0;
			while(opcao<1||opcao>3) {
				System.out.println("Digite o tipo da midia que você deseja adicionar/procurar\n"
						+ "1-Música\n2-PodCast\n3-Audiobook");
				opcao = scanner.nextInt();
				scanner.nextLine();
				switch(opcao) {
					case 1:
						adicionarMusica(scanner,titulo,artista,duracao);
						break;
					case 2:
						adicionarPodcast(titulo,artista,duracao);
						break;
					case 3:
						adicionarAudiobook(titulo,artista,duracao);
						break;
					default:
						throw new OpcaoInvalidaException("Opção invalida!");
				}
			}
		}catch(OpcaoInvalidaException e) {
			System.out.println(e.getMessage());
			menuMidia(scanner,titulo,artista,duracao);
		}
	}
	private Midia menuMidia(Scanner scanner) throws OpcaoInvalidaException, ListaVaziaException, EntradaVaziaException {
		Midia midia = null;
		try {
			int opcao =0;
			while(opcao<1||opcao>3) {
				System.out.printf("Digite qual a opção você deseja procurar%n1-Titulo%n2-Genero%n3-artista%n");
				opcao = scanner.nextInt();
				scanner.nextLine();
				switch(opcao) {
				case 1:
					midia=buscarTitulo(scanner);
					break;
				case 2:
					midia=buscarGenero(scanner);
					break;
				case 3:
					midia=buscarArtista(scanner);
					break;
				default:
					throw new OpcaoInvalidaException("Opção invalida!");
				}
				
			}
		}catch(OpcaoInvalidaException e) {
			System.out.println(e.getMessage());
			menuMidia(scanner);
		}
		if(midia!=null) {
			return midia;
		}
		return null;
	}
	public void removerMidia(Scanner scanner) throws ListaVaziaException, EntradaVaziaException, OpcaoInvalidaException {
		try {
			Midia midia = buscarMidia(scanner);
			if(midia!=null) {
				midias.remove(midia);
				System.out.println("Midia removida!");
			}
				
		}catch(ListaVaziaException e) {
			System.out.println(e.getMessage());
		}
	}
	private void adicionarMusica(Scanner scanner, String titulo, String artista, int duracao) throws OpcaoInvalidaException {
		int opcao=0;
		try {
			while(opcao<1||opcao>6) {
				System.out.println("Qual o genero da música?\n"
						+ "1-ROCK\n2-FORRO\n3-POP\n4-PAGODE\n5-FUNK\n6-CLASSICA");
				opcao = scanner.nextInt();
				scanner.nextLine();
				switch(opcao){
					case 1:
						Musica rock = new Musica(titulo, artista, duracao, Genero.ROCK);
						midias.add(rock);
						break;
					case 2:
						Musica forro = new Musica(titulo, artista, duracao, Genero.FORRO);
						midias.add(forro);
						break;
					case 3:
						Musica pop = new Musica(titulo, artista, duracao, Genero.POP);
						midias.add(pop);
						break;
					case 4:
						Musica pagode = new Musica(titulo, artista, duracao, Genero.PAGODE);
						midias.add(pagode);
						break;
					case 5:
						Musica funk = new Musica(titulo, artista, duracao, Genero.FUNK);
						midias.add(funk);
						break;
					case 6:
						Musica classica = new Musica(titulo, artista, duracao, Genero.CLASSICA);
						midias.add(classica);
						break;
					default:
						throw new OpcaoInvalidaException("Opção invalida!");
				}
			}
		}catch(OpcaoInvalidaException e) {
			System.out.println(e.getMessage());
			adicionarMusica(scanner, artista, artista, opcao);
		}
		
	}
	
	private void adicionarPodcast(String titulo, String artista,int duracao) {
		Podcast podcast = new Podcast (titulo, artista, duracao, Genero.PODCAST);
		midias.add(podcast);
	}
	private void adicionarAudiobook(String titulo, String artista,int duracao) {
		Audiobook audiobook = new Audiobook (titulo, artista, duracao, Genero.AUDIOBOOK);
		midias.add(audiobook);
	}
	
	public void exibirTodas() {
		for ( Midia midia : midias) {
			System.out.println(midia);
		}
	}
	
	
}
