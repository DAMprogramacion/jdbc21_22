package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionDS {
	private static BasicDataSource ds = null;
	public synchronized static Connection getConnection() throws IOException, SQLException {
		Connection conn = null;
		if (ds == null) {
			Properties props = new Properties();
			InputStream is = ConexionDS.class.getClassLoader().getResourceAsStream("db.properties");
			props.load(is);
			
			ds = new BasicDataSource();
			ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
			ds.setUrl(props.getProperty("MYSQL_DB_URL"));
			ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
			
			//pool de conexion
			ds.setInitialSize(10);
			ds.setMaxTotal(30);
			
			//establecemos la conexion
			conn = ds.getConnection();
			
		}
		return conn; 
		
	}
	
}
