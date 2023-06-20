package cl.awakelab.model.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import cl.awakelab.model.cnn.Conexion;
import cl.awakelab.model.dto.Actor;

public class ActorDAO implements IActorDAO {

	@Override
	public void create(Actor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Actor> read() {

		List<Actor> lista = new ArrayList<Actor>();
		
		try {
			
			Connection conn = Conexion.getConexion();
			
			Statement statement = conn.createStatement();
			String sql = "select actor_id, first_name, last_name from actor";
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Actor a = new Actor();
				a.setActorId(result.getInt("actor_id"));
				a.setFirstName(result.getString("first_name"));
				a.setLastName(result.getString("last_name"));
				
				lista.add(a);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en el método read()");
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public Actor read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Actor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
