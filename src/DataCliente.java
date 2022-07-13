import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataCliente {
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/northwind";
	private static final String user = "root";
	private static final String clave = "";

	Variables var = new Variables();

	static {
		try {
			Class.forName(controlador);
			System.out.println(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(true);
		}
	}

	public Connection conectar() {
		Connection conectar = null;
		try {
			conectar = DriverManager.getConnection(url, user, clave);
			System.out.println(true);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(false);
		}
		return conectar;
	}

	public boolean ingresarCliente() {
		DataCliente conexion = new DataCliente();
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = conexion.conectar();
			String query = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(query);

			pstm.setString(1, Variables.id);
			pstm.setString(2, Variables.comname);
			pstm.setString(3, Variables.contacname);
			pstm.setString(4, Variables.contactitle);
			pstm.setString(5, Variables.address);
			pstm.setString(6, Variables.city);
			pstm.setString(7, Variables.reg);
			pstm.setString(8, Variables.postalcode);
			pstm.setString(9, Variables.country);
			pstm.setString(10, Variables.phone);
			pstm.setString(11, Variables.fax);

			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Ingresado");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cliente no Ingresado");

			return false;
		}
	}

	public boolean consultarCliente() {
		DataCliente conexion = new DataCliente();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			String buscar = JOptionPane.showInputDialog(null, "Id del usuario a consultar");
			String query = "SELECT * FROM customers WHERE CustomerID=?";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, buscar);

			rs = pstm.executeQuery();
			while (rs.next()) {

				Variables.id = rs.getString(1);
				Variables.comname = rs.getString(2);
				Variables.contacname = rs.getString(3);
				Variables.contactitle = rs.getString(4);
				Variables.address = rs.getString(5);
				Variables.city = rs.getString(6);
				Variables.reg = rs.getString(7);
				Variables.postalcode = rs.getString(8);
				Variables.country = rs.getString(9);
				Variables.phone = rs.getString(10);
				Variables.fax = rs.getString(11);

				System.out.printf("Id : " + Variables.id + " CompanyName :" + Variables.comname + " ContactName: "
						+ Variables.contacname + "ContactTitle " + Variables.contactitle + " Address "
						+ Variables.address + " City " + Variables.city + " Region " + Variables.reg + " PostalCode "
						+ Variables.postalcode + " Country " + Variables.country + " Phone " + Variables.phone + " Fax "
						+ Variables.fax);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cliente no encontrado");
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (cn != null) {
					cn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean eliminarCliente() {
		DataCliente conexion = new DataCliente();
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = conexion.conectar();
			String query = "DELETE FROM customers WHERE CustomerID=? ";
			String buscar = JOptionPane.showInputDialog(null, "Id del usuario a eliminar");
			pstm = cn.prepareStatement(query);
			pstm.setString(1, buscar);

			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Eliminado");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cliente no Eliminado");

			return false;
		}
	}

	public boolean modificarCliente() {
		DataCliente conexion = new DataCliente();
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = conexion.conectar();
			String query = "UPDATE customers SET CustomerID ='" + Variables.id + "',`CompanyName`='" + Variables.comname
					+ "',`ContactName`='" + Variables.contacname + "',`ContactTitle`='" + Variables.contactitle
					+ "',`Address`='" + Variables.address + "',`City`='" + Variables.city + "',`Region`=' "
					+ Variables.reg + "',`PostalCode`='" + Variables.postalcode + "',`Country`='" + Variables.id
					+ "',`Phone`='" + Variables.phone + "',`Fax`='" + Variables.fax + "' WHERE CustomerID ='"
					+ Variables.id + "'";
			pstm = cn.prepareStatement(query);

			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Modificado");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cliente no Modificado");

			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataCliente conexion = new DataCliente();
		conexion.conectar();
	}

}
