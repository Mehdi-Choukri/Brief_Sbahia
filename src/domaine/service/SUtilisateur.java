package domaine.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.classes.AES;
import domaine.classes.Utilisateur;
import domaine.connexion.DatabaseConnection;

public class SUtilisateur {
	
	public Utilisateur login(String email,String password)
	{
		Connection connect = DatabaseConnection.getConnection();
		Utilisateur utilisateur = null ;
		String hashedPassword = AES.encrypt(password, getSalt(email)) ;
		 
		 
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"Utilisateur\" WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, hashedPassword);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				try {
					utilisateur.setPassword(rs.getString("password"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				utilisateur.setSalt(rs.getString("salt"));
				utilisateur.setNivDroit(rs.getInt("nivDroit"));
				utilisateur.setVille(rs.getString("ville"));
			 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;
	}
	public String getSalt(String email)
	{
		Connection connect = DatabaseConnection.getConnection();
		String salt="";
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT salt FROM \"Utilisateur\" WHERE email = ?");
			ps.setString(1, email);
		 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				 
				salt =rs.getString("salt");
	 
			 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salt;
		
		
	}
	public Boolean checkEmailExist(String email)
	{
		Boolean exist = false;
		Connection connect = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"Utilisateur\" WHERE email = ?");
			ps.setString(1, email);
		 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{ 
				exist = true;
	 
			 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return exist;
		
	}

}
