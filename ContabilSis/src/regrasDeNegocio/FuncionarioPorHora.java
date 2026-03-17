package regrasDeNegocio;

public class FuncionarioPorHora extends Funcionario{
	
	private int horasTrabalhadas;
	private double salarioPorHora;
	
	@Override
	public double calcularSalario() {
		return this.getHorasTrabalhadas() * this.getSalarioPorHora();
	}
	
	public FuncionarioPorHora(int i, String n, int ht, double s) {
		super(i,n);
		this.setHorasTrabalhadas(ht);
		this.setSalarioPorHora(s);
	}
	
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public double getSalarioPorHora() {
		return salarioPorHora;
	}
	public void setSalarioPorHora(double salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}

}
