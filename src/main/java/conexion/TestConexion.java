package conexion;

import java.io.IOException;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Conexion.getInstance());
			System.out.println(Conexion.getInstance());
			System.out.println(Conexion.getInstance());
			System.out.println(ConexionRS.getConnection());
			System.out.println(ConexionRS.getConnection());
			System.out.println(ConexionRS.getConnection());
			System.out.println(ConexionDS.getConnection());
			System.out.println(ConexionDS.getConnection());
			System.out.println(ConexionDS.getConnection());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
