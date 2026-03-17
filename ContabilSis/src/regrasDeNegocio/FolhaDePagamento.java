package regrasDeNegocio;

import java.util.LinkedList;

public class FolhaDePagamento {

	private LinkedList<Funcionario> funcs;
	
	public FolhaDePagamento() {
		this.funcs = new LinkedList<>();	
	}
	
	public void addFuncionario(Funcionario f) {
		this.funcs.add(f);
	}
	
	public void removeFuncionario(Funcionario f) {
		this.funcs.remove(f);
	}
	
	public Funcionario getFuncionario(int idx) {
		return this.funcs.get(idx);
	}
	
	public String imprimirSalario() {
		String retorno = "Folha de pagamento\n";
		for (Funcionario f : this.funcs) {
			retorno += f.getNome() + " - " + Double.toString(f.calcularSalario()) + "\n";
		}
		return retorno;
	}
	
}
