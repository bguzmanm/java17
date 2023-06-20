package cl.awakelab.model.service;

import java.util.List;

import cl.awakelab.model.dao.ActorDAO;
import cl.awakelab.model.dto.Actor;

public class ActorService {
	
	private ActorDAO actorDAO = new ActorDAO();
	
	
	public List<Actor> findAll(){
		return actorDAO.read();		
	}
	
	public Actor findOne(int id) {
		return actorDAO.read(id);
	}
	
	public void update(Actor a) {
		actorDAO.update(a);
	}
	
	public void create(Actor a) {
		actorDAO.create(a);
	}
	
	public void delete(int id) {
		actorDAO.delete(id);
	}
	
	

}
