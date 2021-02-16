package domaine.classes;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int nivDroit;
	private String ville;
	private String salt;
	
	
	
	public Utilisateur(String nom, String prenom, String email,
			String password, int nivDroit, String salt,String ville) {
		try {
		setPassword (password);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.nivDroit = nivDroit;
		this.salt = salt;
		this.ville = ville;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public Utilisateur(int id,String nom, String prenom, String email,
			String password, int nivDroit, String salt,String ville) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.nivDroit = nivDroit;
		this.salt = salt;
		this.ville = ville;
	
	}
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", password=" + password + ", nivDroit="
				+ nivDroit + ", ville=" + ville + ", salt=" + salt + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws Exception {
		if(password.length()>=8)
		{
			this.password = password;
		}
		else
		{
			 
			throw new Exception ("Password must be 8 char min");
		}
		
	}
	public int getNivDroit() {
		return nivDroit;
	}
	public void setNivDroit(int nivDroit) {
		this.nivDroit = nivDroit;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	

}
