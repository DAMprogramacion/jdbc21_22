package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

	private static Conexion conexion;
	private Connection connection;

	private Conexion() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://172.17.0.2/database1?user=manolo&password=manolo");
	}

	public Connection getConnection() {
		return connection;
	}

	public static Conexion getInstance() throws SQLException {
		if (conexion == null)
			conexion = new Conexion();
		Runtime.getRuntime().addShutdownHook(new HookCierreConexion());
		return conexion;
	}

	static class HookCierreConexion  extends Thread  {
        @Override
        public void run() {
            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.getConnection();
                if (connection != null) {
                	connection.close();
                    System.out.println("cerrada la conexión");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            
            }
        }

	}
}
