package dao;

import java.sql.Connection;

import domaine.classes.Produit;
import domaine.classes.Token;
import domaine.classes.Utilisateur;
import domaine.classes.VoteProduit;
import domaine.connexion.DatabaseConnection;
import domaine.service.SProduit;
import domaine.service.SUtilisateur;

public class testDao {

	public static void main(String[] args) {
		/*
		
		 
		  Utilisateur U = new Utilisateur("Hafidi", "Rachid", "med@gmaiL.com", "123456", 0 ,"1555235464","Rabat" );
		 
	//	 Connection connect = DatabaseConnection.getConnection();
		// System.out.println(connect);
		//UDI.save(new Utilisateur("choukri", "mehdi", "med@gmaiL.com", "123456", 0 ,"1555235464","safio" ));
		UDI.save(U);
		System.out.println(U.toString());
		*/
		  /*
		 UtilisateurDaoImp UDI = new UtilisateurDaoImp();
		Token T = new Token();
		Produit P = new Produit("DES lord", 22.4, 20, 0, "Tagine", "webdynamique");
		
		ProduitDaoImp PDI = new ProduitDaoImp();
		 
		for (Produit p : PDI.Search("%%")) {
			System.out.println(p.toString());
		}
		*/
		 SUtilisateur su = new SUtilisateur();
		 
		System.out.println(su.checkEmailExist("ahmed@mail.com")); 
	 
 
		 
		
	 
		 
			
		 
	 

	}

}
