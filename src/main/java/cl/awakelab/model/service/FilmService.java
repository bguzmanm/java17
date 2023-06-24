package cl.awakelab.model.service;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.model.dao.FilmDAO;
import cl.awakelab.model.dto.Film;

public class FilmService {
	
	private FilmDAO filmDAO = new FilmDAO();
	

	public List<Film> findByActorId(int id){
		return filmDAO.findByActorId(id);
	}
	
	public Film findOne(int id) {
		return filmDAO.read(id);
	}
	
	public List<Film> findAll(){
		return filmDAO.read();
	}
	
}
