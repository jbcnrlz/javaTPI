package regrasDeNegocio;

public class FuncionarioAssalariado extends Funcionario{
	
	private double salarioFixo;

	public FuncionarioAssalariado(int i, String n, double s) {
		super(i,n);
		this.setSalarioFixo(s);
	}
	
	@Override
	public double calcularSalario() {
		return this.salarioFixo;
	}
	
	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

}
