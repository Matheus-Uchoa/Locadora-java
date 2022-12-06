package aplicacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import locadora.*;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// carga de dados de filmes
		List<Genero> genero1 = new ArrayList<Genero>();
		genero1.add(new Genero("Romance"));
		genero1.add(new Genero("Guerra"));
		List<Genero> genero2 = new ArrayList<Genero>();
		genero2.add(new Genero("Suspense"));
		genero2.add(new Genero("Terror"));
		Map<Integer, Filme> mapaFilmes = new HashMap<Integer, Filme>();
		mapaFilmes.put(1, new Filme(1, "Doutor jivago", 5.65, "Baseado no romance de Boris Pasternak, Dr. Jivago é um médico e poeta que inicialmente apoia a revolução Russa, mas, aos poucos, se desilude com o socialismo", ClassInd.valueOf(2), genero1));
		mapaFilmes.put(0, new Filme(0, "Donnie Darko", 8d, "Donnie Darko é um filme de suspense e sci-fi escrito e dirigido Richard Kelly", ClassInd.valueOf(2), genero2));
		mapaFilmes.put(2, new Filme(2, "Nosferatu", 4.32, "O corretor de imóveis Hutter precisa vender um castelo cujo proprietário é o excêntrico conde Graf Orlock", ClassInd.valueOf(2), genero2));
		
		//Inicialização do login
		Fazerlogin(mapaFilmes);

	}

	public static void Fazerlogin(Map<Integer, Filme> mapaFilmes) {
		Scanner scan = new Scanner(System.in);

		Login login = new Login(null, null);
		System.out.println("---------LOCADORA--------");
		System.out.println("Bem vindo, Faça o seu Login");
		System.out.println("Email:");
		login.setEmail(scan.next());
		System.out.println("Senha:");
		login.setSenha(scan.next());

		if (Login.validarLogin(login.getEmail(), login.getSenha()) == 0
				|| Login.validarLogin(login.getEmail(), login.getSenha()) == 1) {
			Menu menu = new Menu();
			menu.menuAdm(mapaFilmes);
		} else {
			Menu cliente = new Menu();

			cliente.menuCliente(mapaFilmes);
		}

	}

}
