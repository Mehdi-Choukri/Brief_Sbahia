package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
import domaine.classes.Produit;
import domaine.connexion.DatabaseConnection;

public class ProduitDaoImp implements IProduitDao{

	@Override
	public Produit save(Produit P) {
		 
		Connection connect = DatabaseConnection.getConnection();
		 
		try {
			String query = "INSERT INTO  \"Produit\" ( description, prix, \"qteStock\", \"nbrVote\", intitule, \"urlImage\")VALUES ( ?, ?, ?, ?, ? ,?)";
			PreparedStatement ps = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,P.getDescription());
			ps.setDouble(2,P.getPrix());
			ps.setInt(3,P.getQteStock());
			ps.setInt(4,P.getNbrVote());
			ps.setString(5, P.getIntitule());
			ps.setString(6, P.getUrlImage());
			 
			ps.executeUpdate();
	 
	            PreparedStatement psId = connect.prepareStatement("SELECT MAX(id) as maxID FROM \"Produit\" ");
				ResultSet rs = psId.executeQuery();
				if(rs.next())
				{
					P.setId(rs.getInt("maxID"));
				}
			 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return P;
		 
	}

	@Override
	public List<Produit> Search(String intitule) {
		List<Produit> listProduit = new ArrayList<Produit>();
		Connection connect = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"Produit\" WHERE intitule LIKE ? ");
			ps.setString(1, intitule);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Produit p = new Produit();
				p.setUrlImage(rs.getString("urlImage"));
				p.setId(rs.getInt("id"));
				p.setIntitule(rs.getString("intitule"));
				p.setPrix(rs.getDouble("prix"));
				p.setNbrVote(rs.getInt("nbrVote"));
				p.setQteStock(rs.getInt("qteStock"));
				listProduit.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listProduit;
	}

	@Override
	public Produit getProduit(int id) {
		Produit produit = null ;
		Connection connect = DatabaseConnection.getConnection();
			try {
				PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"Produit\" WHERE id = ? ");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					produit = new Produit();
					produit.setId(rs.getInt("id"));
					
					produit.setIntitule(rs.getString("intitule"));
					produit.setPrix(rs.getDouble("prix"));
					produit.setDescription(rs.getString("description"));
					produit.setNbrVote(rs.getInt("nbrVote"));
					produit.setQteStock(rs.getInt("qteStock"));
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return produit;
	}

	@Override
	public Produit update(Produit P) {
		Connection connect = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = connect.prepareStatement("UPDATE \"Produit\" SET intitule=? ,description=? ,prix=? ,\"qteStock\"=? ,\"urlImage\"=? WHERE id =?");
			ps.setString(1,P.getIntitule());
			ps.setString(2,P.getDescription());
			ps.setDouble(3, P.getPrix());
			ps.setInt(4, P.getQteStock());
			ps.setString(5,P.getUrlImage());
			ps.setInt(6, P.getId());
			
			ps.executeUpdate();
		 
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return P;
	}

	@Override
	public int delete(int id) {
		int ret =0;
		Connection connect = DatabaseConnection.getConnection();
		try {
			
			PreparedStatement ps = connect.prepareStatement("DELETE FROM \"Produit\"  WHERE id = ?");
			ps.setInt(1,id);
	 
			ret = ps.executeUpdate();
 
			ps.close();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
	

}
