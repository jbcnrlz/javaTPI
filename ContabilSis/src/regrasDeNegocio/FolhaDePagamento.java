package regrasDeNegocio;

public class FolhaDePagamento {

	public String imprimirSalario(Funcionario f) {
		return f.getNome() + " - " + Double.toString(f.calcularSalario());
	}
	
}
