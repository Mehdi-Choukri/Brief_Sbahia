package dao;

import domaine.classes.VoteProduit;

public interface IVoteProduitDao {
	
	
	public VoteProduit save(VoteProduit VP);
	public VoteProduit checkVote(VoteProduit VP);
	public VoteProduit updateVote(VoteProduit VP);
	public VoteProduit delete(VoteProduit VP);

}
