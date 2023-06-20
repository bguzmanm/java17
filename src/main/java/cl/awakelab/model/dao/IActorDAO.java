package cl.awakelab.model.dao;

import java.util.List;

import cl.awakelab.model.dto.Actor;

public interface IActorDAO {

	/**
	 * C = Create
	 * R = Read
	 * U = Update
	 * D = Delete
	 */
	
	public void create(Actor a);
	public List<Actor> read();
	public Actor read(int id);
	public void update(Actor a);
	public void delete(int id);
	
}
