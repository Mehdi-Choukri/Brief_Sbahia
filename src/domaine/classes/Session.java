package domaine.classes;

public class Session {
	
	private int id;
	private int idUtilisateur;
	private String hash;
	
	
	public Session(int idUtilisateur, String hash) {
		
		this.idUtilisateur = idUtilisateur;
		this.hash = hash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}

	

}
