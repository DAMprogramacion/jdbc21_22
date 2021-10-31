package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import conexion.Conexion;

public class ProductosDAOSQL implements ProductosDAO {

	//crear conexion
	private static Connection conexion;

    static {
        
            try {
				conexion = Conexion.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	
	public List<Producto> listarLibros() {
		// TODO Auto-generated method stub
		return null;
	}

}
