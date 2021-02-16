package dao;

import java.util.List;

import domaine.classes.Utilisateur;


public interface IUtilisateurDao {
	
	public Utilisateur save(Utilisateur U);
	public List<Utilisateur> Search (int id);
	public Utilisateur getUtilisateur(int id);
	public Utilisateur update(Utilisateur U);
	public int delete (int id);

}
