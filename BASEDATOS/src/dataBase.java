import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBase {
	
	private static String db="deposito";
	private static String user = "lukee";
	private static String pass = "localhost" ;
	private static String host ="localhost:3306";
	private static String server = "jdbc:mysql://"+host+"/"+db;
	
	public static Connection getConexion() {
		
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn= DriverManager.getConnection(server,user,pass);
		}catch(Exception e) {
			System.out.println(String.valueOf(e));
			}
			return cn;
		
	}
	
	public static ResultSet getTabla(String Consulta) {
			Connection cn = getConexion();
			Statement st;
			ResultSet datos = null;
			try {
				st = cn.createStatement();
				datos = st.executeQuery(Consulta);
				
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			return datos;
			
	}
	
	public static ResultSet getUpdate(String Consulta) {
		Connection cn = getConexion();
		Statement st;
		ResultSet datos = null;
		try {
			st = cn.createStatement();
			((java.sql.Statement)st).executeUpdate(Consulta);
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return datos;
		
}
	public static void closeBd() {
		try {
			getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

