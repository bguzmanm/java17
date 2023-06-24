package cl.awakelab.model.dao;

import java.util.List;

import cl.awakelab.model.dto.Film;

public interface IFilmDAO {
	
	public List<Film> findByActorId(int id);
	public Film read(int id);
	public List<Film> read();

}
