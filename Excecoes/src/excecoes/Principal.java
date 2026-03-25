package excecoes;

public class Principal {

	public static void main(String[] args) {
		int numeros[] = new int[10];
		for (int i = 0;i < numeros.length;i+=1) {
			numeros[i] = i + 1;
		}
		
		try {
			for (int i = 0;i <= numeros.length;i+=1) {
				System.out.print(numeros[i]);
				System.out.print(" ");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Opa, você passou do limite!!!!!!!!");
			e.printStackTrace();
		}
		
	}
	
}
