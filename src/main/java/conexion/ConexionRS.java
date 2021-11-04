package conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ConexionRS {
	
	public synchronized static JdbcRowSet getConnection() throws IOException, SQLException {
		InputStream input = new FileInputStream("src/main/resources/db.properties");
		Properties props = new Properties();
		props.load(input);
		RowSetFactory factory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRs = factory.createJdbcRowSet();
		jdbcRs.setUrl(props.getProperty("MYSQL_DB_URL"));
		jdbcRs.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
		jdbcRs.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		return jdbcRs;
	
	}
}
