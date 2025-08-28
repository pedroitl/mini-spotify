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
	
	public void buscarMidia(Scanner scanner) throws ListaVaziaException, EntradaVaziaException {
		if(midias.size()==0) {
			throw new ListaVaziaException("Não há midias cadastradas!");
		}else {
			try {
				System.out.printf("Digite qual a opção você deseja procurar%n1-Titulo%n2-Genero%n3-artista%n");
				int opcao = scanner.nextInt();
				scanner.nextLine();
				switch(opcao) {
				case 1:
					buscarTitulo(scanner);
					break;
				case 2:
					buscarGenero(scanner);
					break;
				case 3:
					buscarArtista(scanner);
					break;
				}
			}catch(ListaVaziaException e) {
				System.out.println(e.getMessage());
			}catch(EntradaVaziaException e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("O campo só aceita valores numericos e inteiros!");
			}
		}
	}

	private void buscarTitulo(Scanner scanner) throws EntradaVaziaException {
		System.out.println("Digite o nome da midia que você procura");
		String midia = scanner.nextLine();
		if(midia.trim().isEmpty()) {
			throw new EntradaVaziaException("A entrada não pode ser vazia!");
		}
		for (int indice =0; indice<midias.size();indice++) {
			if(midias.get(indice).getTitulo().trim().equalsIgnoreCase(midia)) {
				System.out.println(midias.get(indice));
			}
		}
	}
	private void buscarGenero(Scanner scanner) throws EntradaVaziaException {
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
					}
					break;
				case "FORRO":
					if(midias.get(indice).getGenero() == Genero.FORRO) {
						System.out.println(midias.get(indice));
					}
					break;
				case "POP":
					if(midias.get(indice).getGenero() == Genero.POP) {
						System.out.println(midias.get(indice));
					}
					break;
				case "PAGODE":
					if(midias.get(indice).getGenero() == Genero.PAGODE) {
						System.out.println(midias.get(indice));
					}
					break;
				case "FUNK":
					if(midias.get(indice).getGenero() == Genero.FUNK) {
						System.out.println(midias.get(indice));
					}
					break;
				case "CLASSICA":
					if(midias.get(indice).getGenero() == Genero.CLASSICA) {
						System.out.println(midias.get(indice));
					}
					break;
				default:
					System.out.println("Genero não encontrado!");
				}
			}
	}
	private void buscarArtista(Scanner scanner) throws ListaVaziaException,EntradaVaziaException {
			System.out.println("Digite o nome do artista que você procura");
			String artista = scanner.nextLine();
			if(artista.trim().isEmpty()) {
				throw new EntradaVaziaException("A entrada não pode ser vazia!");
			}
				for (int indice = 0; indice< midias.size(); indice ++) {
					if(midias.get(0).getArtista().trim().equalsIgnoreCase(artista)) {
							
					}else {
						System.out.println("Não há artistas com esse nome!");
					}
				}
	}
	public void adicionarMidia(Scanner scanner) throws OpcaoInvalidaException {
		try {
		System.out.println("Digite o nome da midia:");
		String titulo = scanner.nextLine();
		System.out.println("Digite o nome do artista/autor:");
		String artista = scanner.nextLine();
		System.out.println("Digite a duração da midia:");
		int duracao = scanner.nextInt();
		int opcao =0;
		do {
			System.out.println("Digite o tipo da midia que você deseja adicionar\n"
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
		}
		if(opcao<1||opcao>3) {
			throw new OpcaoInvalidaException("Opção invalida!");
		}
		}while(opcao<1||opcao>3);
		}catch(InputMismatchException e) {
			System.out.println("O campo só aceita valores numericos e inteiros!");
		}
		
	}
	public void removerMidia(Scanner scanner) {
		
		
	}
	private void adicionarMusica(Scanner scanner, String titulo, String artista, int duracao) throws OpcaoInvalidaException {
		int opcao=0;
		do {
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
		}
		if(opcao<1||opcao>6) {
			throw new OpcaoInvalidaException("Opção invalida!");
		}
		}while(opcao<1||opcao>6);
		
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
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		Catalogo cat = new Catalogo();
		try {
			cat.adicionarMidia(scanner);
		} catch (OpcaoInvalidaException e) {
			System.out.println(e.getMessage());		}
		try {
			cat.buscarMidia(scanner);
		} catch (ListaVaziaException e) {
			System.out.println(e.getMessage());
		} catch (EntradaVaziaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
