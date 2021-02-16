package domaine.service;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domaine.classes.Produit;
import domaine.connexion.DatabaseConnection;

public class SProduit {
	
	
	public int nbrVoteProduit(int idProduit)
	{
		int nbrVote = 0 ;
		Connection connect = DatabaseConnection.getConnection();
		try{
			String query = "SELECT count(\"idProduit\") as \"nbrVote\" FROM \"Produit\" , \"Vote_Produit\" WHERE  \"id\" =  \"idProduit\"  AND \"Produit\".id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, idProduit);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				nbrVote = rs.getInt("nbrVote");
			}
			
			ps.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return nbrVote;
		
	}
	public void CopyImageDirectory(String urlOriginalFile,String urlDestinationFile)
	{
		File originalFile = new File(urlOriginalFile);
		File newFile = new File(urlDestinationFile);
		try
		{
			Files.copy(originalFile.toPath(), newFile.toPath());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateNbrVote(int idProduit) {
	
		Connection connect = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("UPDATE \"Produit\" SET  \"nbrVote\"=?   WHERE id =?");
			ps.setInt(1, nbrVoteProduit(idProduit));
			ps.setInt(2, idProduit);
		
			
			ps.executeUpdate();
		 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
	}
	public void updateNbrVoteForAll() {
		
		Connection connect = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT id from \"Produit\" ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				updateNbrVote(rs.getInt("id")) ;
			}
 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
	}
	 

}
