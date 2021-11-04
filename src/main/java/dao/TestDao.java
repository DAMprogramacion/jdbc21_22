package dao;

import java.sql.SQLException;
import java.util.List;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ProductosDAO dao = new ProductosDAOSQLRS();
		ProductosDAO dao = new ProductosDAOSQL();
//		try {
//			List<Producto> listaProductos = dao.listarProductos();
//			listaProductos.forEach(System.out::println);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.printf("Borrado registro %B%n", dao.borrarProductoPorId(103));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			System.out.printf("Actualizado registro %B%n" , dao.actualizarPrecioProductoPorId(1, 1500));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Producto nuevo = new Producto("mochila", 200);
//		try {
//			System.out.printf("Insertado nuevo registro %B%n" , dao.insertarNuevoProducto(nuevo));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
