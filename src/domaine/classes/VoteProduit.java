package domaine.classes;

import java.util.Date;

public class VoteProduit {
	
	@Override
	public String toString() {
		return "VoteProduit [idProduit=" + idProduit + ", idUtilisateur="
				+ idUtilisateur + ", dateVote=" + dateVote + "]";
	}
	private int idProduit;
	private int idUtilisateur;
	private Date dateVote;
	
	
	public VoteProduit(int idProduit, int idUtilisateur, Date dateVote) {
		
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
		this.dateVote = dateVote;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public Date getDateVote() {
		return dateVote;
	}
	public void setDateVote(Date dateVote) {
		this.dateVote = dateVote;
	}

}
