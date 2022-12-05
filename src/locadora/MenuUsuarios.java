package locadora;

import java.util.Map;

public interface MenuUsuarios {

	public abstract void menuCliente(Map<Integer, Filme> mapaFilmes);

	public abstract void menuAdm(Map<Integer, Filme> mapaFilmes);
}
