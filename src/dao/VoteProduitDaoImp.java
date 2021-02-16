package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domaine.classes.VoteProduit;
import domaine.connexion.DatabaseConnection;

public class VoteProduitDaoImp implements IVoteProduitDao{

	@Override
	public VoteProduit save(VoteProduit VP) {
		Connection connect = DatabaseConnection.getConnection();
		 
		try {
			String query = "INSERT INTO  \"Vote_Produit\" ( \"idProduit\", \"idUtilisateur\", \"dateVote\") VALUES ( ?, ? ,NOW())";
			 
			PreparedStatement ps = connect.prepareStatement(query);
		 
			ps.setInt(1,VP.getIdProduit());
			ps.setInt(2,VP.getIdUtilisateur());
		 
			 
			ps.executeUpdate();
	  
			 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VP;
	}

	@Override
	public VoteProduit checkVote(VoteProduit VP) {
		Connection connect = DatabaseConnection.getConnection();
		String query = "SELECT count(*) as \"nbrVote\" FROM \"Vote_Produit\" ,\"Utilisateur\" where \"idUtilisateur\" = \"id\" AND \"id\" = ? AND \"idProduit\" = ?";
		 
		int cpt = -99 ;
		try {
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1,VP.getIdUtilisateur());
			ps.setInt(2,VP.getIdProduit());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 cpt = rs.getInt("nbrVote");
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cpt);
		if(cpt>0)
		{
			return null;
		}
		else return VP;
		
	 
		
	 
	}

	@Override
	public VoteProduit updateVote(VoteProduit VP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoteProduit delete(VoteProduit VP) {
		// TODO Auto-generated method stub
		return null;
	}

}
