package dao;

public interface Persistir<E> {

	public boolean salvar(E objeto);
	public boolean excluir (int id);
	public int buscarIDBanco(E objeto);
	
}
