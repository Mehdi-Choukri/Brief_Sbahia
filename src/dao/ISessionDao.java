package dao;

import java.util.List;

import domaine.classes.Session;

 

public interface ISessionDao {
	

	public Session save(Session S);
	public List<Session> Search (int id);
	public Session getSession(int id);
	public Session update(Session S);
	public int delete (int id);

}
