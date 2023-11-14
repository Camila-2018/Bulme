import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexion {
	private static final String Driver="java.sql.Driver";
	private static final String user="root";
	private static final String pass="";
	private static final String url="jdbc:mysql://localhost/bulme";
	
	static {
		try {
			Class.forName(Driver);
			}
		catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "error al cargar la conexión"+ex);
			ex.printStackTrace();
		}
	}
	
	public static Connection Conectar() {
		Connection con=null;
		try {
			con=(Connection) DriverManager.getConnection(url, user, pass);
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error de conexión"+ex);
			ex.printStackTrace();
		}
		return con;
	}
		public static void main(String[] args) {
			conexion c=new conexion();
			c.Conectar();
		}

}
