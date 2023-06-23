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
		
		String sql = "insert into actor (first_name, last_name) values ('" + a.getFirstName() + "', '" + a.getLastName() + "')";
		try {
			
			Connection cnn = Conexion.getConexion();
			Statement st = cnn.createStatement();
			st.execute(sql);			
			
			
		} catch (SQLException e) {
			System.out.println("Error en método create");
			e.printStackTrace();
		}
		
		
		
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

		Actor actor = null;
		
		try {
			
			Connection conn = Conexion.getConexion();
			Statement statement = conn.createStatement();
			String sql = "select actor_id, first_name, last_name from actor where actor_id = " + id;
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				actor = new Actor(
						rs.getInt("actor_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name")
						);
			}			
			
		} catch (SQLException e) {
			System.out.println("Error en el método read(id)");
			e.printStackTrace();
		}
		
		return actor;
	}

	@Override
	public void update(Actor a) {
		
		String sql = "update actor set first_name = '" + a.getFirstName() + "', last_name = '" + a.getLastName() + "' where actor_id = " + a.getActorId();
		
		try {
			
			Connection conn = Conexion.getConexion();
			Statement statement = conn.createStatement();
			
			System.out.println(sql);
			statement.execute(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Erorr en método update");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from actor where actor_id = " + id;
		try {
		
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();
			st.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error en método delete");
			e.printStackTrace();
		}
		
	}

}
