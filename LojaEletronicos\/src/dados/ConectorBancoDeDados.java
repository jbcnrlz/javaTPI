package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBancoDeDados {
	
	public Connection startConnection() {
		Connection cn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			cn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/siseletronicos",
				"jbcnrlz",
				"a12b25c54"
			);
		}catch (ClassNotFoundException ce) {
			System.err.println("Não achou a classe!");
		} catch (SQLException ce) {
			System.err.println("Deu erro no SQL!");
		}
		return cn;
	}

}
