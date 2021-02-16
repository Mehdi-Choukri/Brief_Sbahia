package domaine.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class DatabaseConnection {

	private static Connection connection;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5555/DB_brief_Sbahia", "postgres","root");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return connection;
	}
    
    
}