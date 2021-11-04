package dao;

import java.sql.SQLException;
import java.util.List;

public interface ProductosDAO {
	
	List<Producto> listarProductos() throws SQLException;
	boolean borrarProductoPorId(int id) throws SQLException;
	boolean actualizarPrecioProductoPorId(int id, float nuevoPrecio) throws SQLException;
	boolean insertarNuevoProducto(Producto nuevoProducto) throws SQLException;
	
}
