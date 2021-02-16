package dao;

import java.util.List;

import domaine.classes.Produit;

public interface IProduitDao {
	
	public Produit save(Produit P);
	public List<Produit> Search (String intitule);
	public Produit getProduit(int id);
	public Produit update(Produit P);
	public int delete (int id);

}
