package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



 

import domaine.classes.Utilisateur;
import domaine.connexion.DatabaseConnection;

public class UtilisateurDaoImp implements IUtilisateurDao {

	@Override
	public Utilisateur save(Utilisateur U) {
		 
		Connection connect = DatabaseConnection.getConnection();
		 
		try {
			String query = "INSERT INTO  \"Utilisateur\"( nom, prenom, email, password,\"nivDroit\", salt, ville)VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,U.getNom());
			ps.setString(2,U.getPrenom());
			ps.setString(3,U.getEmail());
			ps.setString(4,U.getPassword());
			ps.setInt(5, U.getNivDroit());
			ps.setString(6, U.getSalt());
			ps.setString(7, U.getVille());
			ps.executeUpdate();
	 
	            PreparedStatement psId = connect.prepareStatement("SELECT MAX(id) as maxID FROM  \"Utilisateur\" ");
				ResultSet rs = psId.executeQuery();
				if(rs.next())
				{
					U.setId(rs.getInt("maxID"));
				}
			 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return U;
	}

	@Override
	public List<Utilisateur> Search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		Connection connect = DatabaseConnection.getConnection();
		Utilisateur utilisateur = null ;
	 
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"Utilisateur\" WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setEmail(rs.getString("email"));
				try {
					utilisateur.setPassword(rs.getString("password"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				utilisateur.setNivDroit(rs.getInt("nivDroit"));
				utilisateur.setVille(rs.getString("ville"));
			 
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;
		 
		 
	}

	@Override
	public Utilisateur update(Utilisateur U) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
