package domaine.classes;

public class Produit {
	
	private int id;
	private String description;
	private double prix;
	private int qteStock;
	private int nbrVote;
	private String intitule;
	private String urlImage;
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", description=" + description + ", prix="
				+ prix + ", qteStock=" + qteStock + ", nbrVote=" + nbrVote
				+ ", intitule=" + intitule + ", urlImage=" + urlImage + "]";
	}
	public Produit(String description, double prix, int qteStock, int nbrVote , String intitule , String url) {
		
		this.description = description;
		this.prix = prix;
		this.qteStock = qteStock;
		this.nbrVote = nbrVote;
		this.intitule = intitule;
		this.urlImage = url;
		
	}
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getNbrVote() {
		return nbrVote;
	}
	public void setNbrVote(int nbrVote) {
		this.nbrVote = nbrVote;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
