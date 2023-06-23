package cl.awakelab.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.model.cnn.Conexion;
import cl.awakelab.model.dto.Film;

public class FilmDAO implements IFilmDAO {

	@Override
	public List<Film> findByActorId(int id) {

		String sql = "select  film.film_id, title, description, release_year, "
				+ "        language_id, original_language_id, "
				+ "        rental_duration, rental_rate, length, replacement_cost, rating, special_features "
				+ "from    film inner join film_actor fa on film.film_id = fa.film_id "
				+ "where   fa.actor_id = " + id;
		
		
		List<Film> lista = new ArrayList<Film>();
		
		try {
			Connection conn = Conexion.getConexion();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				lista.add(new Film(
						rs.getInt("film_id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("release_year"),
						rs.getInt("language_id"),
						rs.getInt("original_language_id"),
						rs.getInt("rental_duration"),
						rs.getFloat("rental_rate"),
						rs.getInt("length"),
						rs.getFloat("replacement_cost"),
						rs.getString("rating"),
						rs.getString("special_features")						
						));
			}
			
		} catch (SQLException e) {
			System.out.println("Error en el método read(id)");
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public Film read(int id) {
		Film film = null;
		
		try {
			
			Connection conn = Conexion.getConexion();
			Statement statement = conn.createStatement();
			String sql = "select film_id, title, description, release_year, language_id, original_language_id, "
					+ "rental_duration, rental_rate, length, replacement_cost, rating, special_features "
					+ "from film where film_id = " + id;
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				film = new Film(
						rs.getInt("film_id"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("release_year"),
						rs.getInt("language_id"),
						rs.getInt("original_language_id"),
						rs.getInt("rental_duration"),
						rs.getFloat("rental_rate"),
						rs.getInt("length"),
						rs.getFloat("replacement_cost"),
						rs.getString("rating"),
						rs.getString("special_features")
						);
			}			
			
		} catch (SQLException e) {
			System.out.println("Error en el método read(id)");
			e.printStackTrace();
		}
		
		return film;
		
	}

}
