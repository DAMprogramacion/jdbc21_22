package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import conexion.Conexion;
import conexion.ConexionDS;

public class ProductosDAOSQL implements ProductosDAO {

	//crear conexion
	private static Connection conexion;

    static {
        
            try {
				conexion = ConexionDS.getConnection();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

	public List<Producto> listarProductos() throws SQLException {
		List<Producto> listaProductos = new ArrayList<>();
		String sql = "SELECT * FROM products;";
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(sql);
		while (resultado.next()) {
			listaProductos.add(new Producto(resultado.getInt(1), resultado.getString(2), resultado.getFloat(3)));
		}
		return listaProductos;
	}

	public boolean borrarProductoPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM products WHERE id = ?;";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, id);
		int ejecucion = sentencia.executeUpdate();
		return ejecucion != 0;
	}

	public boolean actualizarPrecioProductoPorId(int id, float nuevoPrecio) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE products SET prices = ? WHERE id = ?;";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setFloat(1, nuevoPrecio);
		sentencia.setInt(2, id);
		int ejecucion = sentencia.executeUpdate();
		return ejecucion != 0;
	}

	public boolean insertarNuevoProducto(Producto nuevoProducto) throws SQLException {
		String sql = "INSERT INTO products (name, prices) VALUES (?, ?);";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, nuevoProducto.getName());
		sentencia.setFloat(2, nuevoProducto.getPrices());
		int ejecucion = sentencia.executeUpdate();
		return ejecucion != 0;
	}
	
	

}
