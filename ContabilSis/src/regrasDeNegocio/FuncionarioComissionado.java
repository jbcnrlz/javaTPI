package regrasDeNegocio;

public class FuncionarioComissionado extends Funcionario{

	private double vendas;
	private double percentualComissao;
	
	@Override
	public double calcularSalario() {
		return this.getVendas() * this.getPercentualComissao();
	}
	
	public FuncionarioComissionado(int i, String n, double v, double p) {
		super(i,n);
		this.setVendas(v);
		this.setPercentualComissao(p);
	}
	
	public double getVendas() {
		return vendas;
	}
	public void setVendas(double vendas) {
		this.vendas = vendas;
	}
	public double getPercentualComissao() {
		return percentualComissao;
	}
	public void setPercentualComissao(double percentualComissao) {
		if (percentualComissao > 1) {
			percentualComissao = percentualComissao / 100.0;
		}
		this.percentualComissao = percentualComissao;
	}
	
}
