package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Login {

	Scanner scan = new Scanner(System.in);

	private static List<Login> listaLogin;
	private String email;
	private String senha;

	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static int validarLogin(String email, String senha) {
		cargaDados();
		int index = listaLogin.indexOf(new Login(email, senha));
		if (index == -1) {
			return (Integer) null;
		}
		System.out.println("entrou no validar login e o index: " + index);
		return index;
	}

	public static void cargaDados() {
		if (listaLogin == null) {
			listaLogin = new ArrayList<Login>();
			listaLogin.add(new Login("joaopedro@gmail.com", "111"));
			listaLogin.add(new Login("matheus@gmail.com", "222"));
			listaLogin.add(new Login("mariana@gmail.com", "333"));
			listaLogin.add(new Login("joana@gmail.com", "444"));
			listaLogin.add(new Login("felipe@gmail.com", "555"));
			listaLogin.add(new Login("gabriel@gmail.com", "666"));
			listaLogin.add(new Login("goku@gmail.com", "777"));
			listaLogin.add(new Login("naruto@gmail.com", "888"));

		}
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(email, other.email) && Objects.equals(senha, other.senha);
	}

}
