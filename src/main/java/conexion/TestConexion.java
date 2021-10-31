package conexion;

import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Conexion.getInstance());
			System.out.println(Conexion.getInstance());
			System.out.println(Conexion.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
