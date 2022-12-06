package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Genero {
	String genero;

	public Genero(String genero) {
		super();
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static Genero lerDados() {
		Scanner leitor = new Scanner(System.in);
		Genero genero = new Genero(null);
		System.out.println("Informe o gênero do filme");
		genero.setGenero(leitor.next());

		return genero;

	}

	@Override
	public String toString() {
		return genero;
	}

}
