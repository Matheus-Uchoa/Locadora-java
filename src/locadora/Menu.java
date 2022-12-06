package locadora;

import java.util.Map;
import java.util.Scanner;

import aplicacao.Principal;

public class Menu implements MenuUsuarios {
	private static Scanner scan = new Scanner(System.in);

	@Override
	public void menuAdm(Map<Integer, Filme> mapaFilmes) {

		int opcao = 0;
		do {
			System.out.println(
					"-----SELECIONE UMA OPÇÃO----- \n 1- Adicionar novo filme \n 2- Excluir filme \n 3- Alterar filme \n 4- Imprimir filmes \n 5- Sair");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				Filme filme = Filme.lerDados();
				mapaFilmes.put(filme.getId(), filme);
				break;
			case 2:
				Filme.removerFilme(mapaFilmes);
				break;

			case 3:
				Filme filmeAlterado = Filme.alterarFilme(mapaFilmes);
				if (filmeAlterado != null) {
					mapaFilmes.put(filmeAlterado.getId(), filmeAlterado);
				}

				break;

			case 4:
				int opcaoImpressao;

				do {
					System.out.println(
							"\n Selecione a opção de impressão: 1-Ordenada por valor 2- Ordenada por ID 3-Imprimir ordenado por nome 4-Voltar");
					opcaoImpressao = scan.nextInt();
					System.out.println();
					switch (opcaoImpressao) {
					case 1:
						Filme.imprimirOrdenandoId(mapaFilmes);
						break;

					case 2:
						Filme.imprimir(mapaFilmes);
						break;

					case 3:
						Filme.imprimirOrdenandoNome(mapaFilmes);
						break;
					}
				} while (opcaoImpressao != 4);
				break;

			case 5:
				Principal.Fazerlogin(mapaFilmes);
				break;

			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
		} while (opcao != 5);
	}

	@Override
	public void menuCliente(Map<Integer, Filme> mapaFilmes) {
		int opcao;
		do {
			System.out.println(
					"-----SELECIONE UMA OPÇÃO----- \n 1- Alugar filme(s) \n 2- Ver filme(s) alugados \n 3- Ver filmes disponíveis \n 4- Sair");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				Filme.alugarFilme(mapaFilmes);
				break;

			case 2:
				Filme.verFilmesAlugados();
				break;

			case 3:
				int opcaoImpressao;

				do {
					System.out.println(
							"\n Selecione a opção de impressão: 1-Ordenada por valor 2- Ordenada por ID 3-Imprimir ordenado por nome 4-Voltar");
					opcaoImpressao = scan.nextInt();
					System.out.println();
					switch (opcaoImpressao) {
					case 1:
						Filme.imprimirOrdenandoId(mapaFilmes);
						break;

					case 2:
						Filme.imprimir(mapaFilmes);
						break;

					case 3:
						Filme.imprimirOrdenandoNome(mapaFilmes);
						break;
					}
				} while (opcaoImpressao != 4);
				break;
			case 4:
				Principal.Fazerlogin(mapaFilmes);
				break;
			default:
				System.out.println("Selecione uma opção válida");
				break;
			}
		} while (opcao != 4);
	}
}
