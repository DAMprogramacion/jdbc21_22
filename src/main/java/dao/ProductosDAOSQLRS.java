package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import conexion.Conexion;
import conexion.ConexionRS;

public class ProductosDAOSQLRS implements ProductosDAO {

	// crear RowSet
	private static JdbcRowSet rowset;

	static {

		try {
			rowset = ConexionRS.getConnection();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Producto> listarProductos() throws SQLException {
		List<Producto> listaProductos = new ArrayList<>();
		String sql = "SELECT * FROM products;";
		rowset.setCommand(sql);
		rowset.execute();
		while (rowset.next()) {
			listaProductos.add(new Producto(rowset.getInt(1), rowset.getString(2), rowset.getFloat(3)));
		}
		return listaProductos;
	}

	@Override
	public boolean borrarProductoPorId(int id) throws SQLException {
		boolean borrado = false;
		String sql = "SELECT * FROM products;";
		rowset.setCommand(sql);
		rowset.execute();

		while (rowset.next()) {
			if (rowset.getInt("id") == id) {
				rowset.deleteRow();
				borrado = true;
				break;
			}
		}
		return borrado;
	}

	@Override
	public boolean actualizarPrecioProductoPorId(int id, float nuevoPrecio) throws SQLException {
		boolean actualizado = false;
		String sql = "SELECT * FROM products;";
		rowset.setCommand(sql);
		rowset.execute();
		// int contador = 0;
		while (rowset.next()) {
			if (rowset.getInt("id") == id) {
				// System.out.println(rowset.getString("name"));
				// rowset.absolute(contador);
				rowset.updateFloat(3, nuevoPrecio);
				rowset.updateRow();
				actualizado = true;
				break;
			}
			// contador++;

		}
		return actualizado;
	}

	@Override
	public boolean insertarNuevoProducto(Producto nuevoProducto) throws SQLException {

		String sql = "SELECT * FROM products;";
		rowset.setCommand(sql);
		rowset.execute();

		rowset.moveToInsertRow();
		rowset.updateString("name", nuevoProducto.getName());
		rowset.updateFloat("prices", nuevoProducto.getPrices());
		rowset.insertRow();
//		String sql = "INSERT INTO products (name, prices) VALUES (?, ?);";
//		PreparedStatement sentencia = conexion.prepareStatement(sql);
//		sentencia.setString(1, nuevoProducto.getName());
//		sentencia.setFloat(2, nuevoProducto.getPrices());
//		int ejecucion = sentencia.executeUpdate();
//		return ejecucion != 0;
		return false;
	}

	@Override
	public boolean actualizarPrecioProductos(int porcentaje) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
