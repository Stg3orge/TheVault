package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Breed;

public class BreedDB implements BreedDBIF {

	@Override
	public Breed create(Breed breed) throws SQLException {
		String sql = "insert into breed (name, max_weight, description) values ("
				+ "'" + breed.getName() + "'"
				+ ", " + breed.getMaxWeight() + ""
				+ ", '" + breed.getDescription() + "'  )";
		int id = DBConnection.getInstance().executeInsertWithIdentity(sql);
		breed.setId(id);
		return breed;
	}

	@Override
	public Breed update(Breed breed) throws SQLException {
		String sql = "update breed set "
				+ "name='" + breed.getName() + "'"
				+ ", max_weight = " + breed.getMaxWeight() 
				+ ", description = '" + breed.getDescription() + "' "
				+ "where id = " + breed.getId() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? breed : null;
	}

	@Override
	public boolean delete(Breed breed) throws SQLException {
		String sql = "delete from breed where id = " + breed.getId();
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}

	@Override
	public List<Breed> getAll() throws SQLException {
		String sql = "select id, name, max_weight, description from breed";
		System.out.println("BreedDB, Query: " + sql);
		try (Statement s = DBConnection.getInstance().getConnection().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Breed> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Breed findById(int id) throws SQLException {
		Breed res = null;
		String sql = "select id, name, max_weight, description from breed where id = " + id;
		System.out.println("BreedDB, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;		
		
	}
	
	private Breed buildObject(ResultSet rs) throws SQLException {
		Breed b = null;
		b = new Breed();
		b.setId(rs.getInt("id"));
		b.setName(rs.getString("name"));
		b.setDescription(rs.getString("description"));
		b.setMaxWeight(rs.getInt("max_weight"));
		return b;
	}
	
	private ArrayList<Breed> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Breed> res = new ArrayList<>();
		while(rs.next()) {
			Breed b = buildObject(rs);
			res.add(b);
		}
		return res;
	}

	@Override
	public List<Breed> findByName(String name) throws SQLException {
		ArrayList<Breed> res = new ArrayList<>();
		
		String sql = "select id, name, max_weight, description from breed where name like '%" + name + "%'";
		System.out.println("BreedDB, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return res;
	}

}
