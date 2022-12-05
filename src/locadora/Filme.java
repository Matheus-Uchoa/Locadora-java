package locadora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

public class Filme {
	private static Integer id;
	private String nome;
	private Double valor;
	private String resumo;
	private ClassInd classInd;
	private List<Genero> genero;
	private String dataCadastro;
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Filme(Integer id, String nome, Double valor, String resumo, ClassInd classInd, List<Genero> genero) {

		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.resumo = resumo;
		this.classInd = classInd;
		this.genero = genero;
		this.dataCadastro = LocalDate.now().format(formatter);

	}

	public Filme() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public ClassInd getClassInd() {
		return classInd;
	}

	public void setClassInd(ClassInd classInd) {
		this.classInd = classInd;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String string) {
		this.dataCadastro = string;
	}

	@Override
	public String toString() {
		return " Título: " + nome + "| Valor: " + valor + "| Resumo: " + resumo + "| Classificação Indicativa: "
				+ classInd + "| Genero(s)" + genero + "| Data de Cadastro " + dataCadastro;
	}

	public static Filme lerDados() {
		Scanner scan = new Scanner(System.in);
		Filme filme = new Filme();

		System.out.println("Informe o título do filme: ");
		filme.setNome(scan.nextLine());
		System.out.println("Informe o valor do filme:");
		filme.setValor(scan.nextDouble());
		scan.nextLine();

		System.out.println("Selecione uma das classificações: ");
		for (ClassInd classInd : ClassInd.values()) {
			System.out.println(classInd.getId() + " - " + classInd.getLabel());

		}
		filme.setClassInd(ClassInd.valueOf(scan.nextInt()));
		scan.nextLine();

		System.out.println("Deseja adicionar um Gênero ao filme? 1 - sim");
		int opcao = scan.nextInt();
		scan.nextLine();
		if (opcao == 1)
			filme.setGenero(new ArrayList<Genero>());

		while (opcao == 1) {
			filme.getGenero().add(Genero.lerDados());
			System.out.println("Deseja adicionar outro Gênero? 1 - sim");
			opcao = scan.nextInt();
			scan.nextLine();
		}

		System.out.println("Informe o resumo do filme");
		filme.setResumo(scan.nextLine());

		System.out.println("Informe o Id do filme: ");
		filme.setId(scan.nextInt());
		scan.nextLine();

		filme.setDataCadastro(LocalDate.now().format(formatter));
		return filme;

	}

	public static void removerFilme(Map<Integer, Filme> mapa) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o id do filme que deseja remover: ");
		Integer id = scan.nextInt();
		if (mapa.get(id) == null) {
			System.out.println("filme não encontrado");
		}
		mapa.remove(id);
	}

	public static Filme alterarFilme(Map<Integer, Filme> mapa) {
		Scanner scan = new Scanner(System.in);
		Filme filme = new Filme();
		System.out.println("Informe o id do filme que deseja alterar: ");
		Integer id = scan.nextInt();
		scan.nextLine();
		filme.setId(id);
		if (mapa.get(id) == null) {
			System.out.println("Filme não encontrado");
		}

		else if (mapa.get(id) != null) {
			System.out.println("Informe o novo nome do Filme: ");
			filme.setNome(scan.nextLine());

			while (filme.getValor() == null) {
				System.out.println("Informe o novo valor do filme: ");
				try {
					filme.setValor(scan.nextDouble());
					scan.nextLine();
				} catch (Exception e) {
					System.err.println("O valor do produto deve ser numérico. Tente novamente.");
					scan.nextLine();
				}
			}

			System.out.println("Informe o novo resumo do filme: ");
			filme.setResumo(scan.nextLine());

			System.out.println("Deseja adicionar um novo Gênero ao filme? 1 - sim");
			int opcao = scan.nextInt();
			scan.nextLine();
			if (opcao == 1)
				filme.setGenero(new ArrayList<Genero>());

			while (opcao == 1) {
				filme.getGenero().add(Genero.lerDados());
				System.out.println("Deseja adicionar outro Gênero? 1 - sim");
				opcao = scan.nextInt();
				scan.nextLine();
			}

			System.out.println("Selecione uma nova classificação: ");
			for (ClassInd classInd : ClassInd.values()) {
				System.out.println(classInd.getId() + " - " + classInd.getLabel());

			}
			filme.setClassInd(ClassInd.valueOf(scan.nextInt()));
			scan.nextLine();

			return filme;
		}
		return null;
	}

	public static void imprimir(Map<Integer, Filme> mapa) {
		if (mapa.isEmpty() == true) {
			System.out.println("Não há itens cadastrados." + "");
		}
		mapa.forEach((k, v) -> System.out.println(k + ": " + v));
	}

	public static void imprimirOrdenandoId(Map<Integer, Filme> mapa) {
		Map<Integer, Filme> mapaOrdenado = mapa.entrySet().stream()
				.sorted((e1, e2) -> Double.compare(e1.getValue().getValor(), e2.getValue().getValor()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		mapaOrdenado.forEach((k, v) -> System.out.println(k + ":" + v));
	}

	public static void imprimirOrdenandoNome(Map<Integer, Filme> mapa) {
		Map<Integer, Filme> sortedNewMap = mapa.entrySet().stream()
				.sorted((e1, e2) -> e1.getValue().getNome().compareTo(e2.getValue().getNome()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		sortedNewMap.forEach((key, val) -> {
			System.out.println(key + " = " + val.toString());
		});
	}
}
