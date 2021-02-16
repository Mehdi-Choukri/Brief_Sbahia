package domaine.web;

import java.util.ArrayList;
import java.util.List;
 
import domaine.classes.Produit;

public class ProduitModel {
	private String intituleSearched;
	private List<Produit> listeProduit = new ArrayList<Produit>();
	public String getIntituleSearched() {
		return intituleSearched;
	}
	public void setIntituleSearched(String intituleSearched) {
		this.intituleSearched = intituleSearched;
	}
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(ArrayList<Produit> listeArticle) {
		this.listeProduit = listeArticle;
	}

}
