package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Breed;

public class BreedDB implements BreedDBIF {
	private PreparedStatement insertPs, updatePs, deletePs, findByIdPs, findByNamePs;
	
	public BreedDB() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		insertPs = con.prepareStatement("insert into breed (name, max_weight, description) values (?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
		updatePs = con.prepareStatement("update breed set name = ?, max_weight = ?, description = ? where id = ?");
		deletePs = con.prepareStatement("delete from breed where id = ?");
		findByIdPs = con.prepareStatement("select id, name, max_weight, description from breed where id = ?");
		findByNamePs = con.prepareStatement("select id, name, max_weight, description from breed where name like ?");
	}

	@Override
	public Breed create(Breed breed) throws SQLException {
//		String sql = "insert into breed (name, max_weight, description) values ("
//				+ "'" + breed.getName() + "'"
//				+ ", " + breed.getMaxWeight() + ""
//				+ ", '" + breed.getDescription() + "'  )";
		insertPs.setString(1,  breed.getName());
		insertPs.setInt(2, breed.getMaxWeight());
		insertPs.setString(3, breed.getDescription());
		
		int id = DBConnection.getInstance().executeInsertWithIdentity(insertPs);
		breed.setId(id);
		return breed;
	}

	@Override
	public Breed update(Breed breed) throws SQLException {
//		String sql = "update breed set "
//				+ "name='" + breed.getName() + "'"
//				+ ", max_weight = " + breed.getMaxWeight() 
//				+ ", description = '" + breed.getDescription() + "' "
//				+ "where id = " + breed.getId() + "";
		updatePs.setString(1, breed.getName());
		updatePs.setInt(2,  breed.getMaxWeight());
		updatePs.setString(3, breed.getDescription());
		updatePs.setInt(4,  breed.getId());
		int res = updatePs.executeUpdate();
//		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? breed : null;
	}

	
	@Override
	public boolean delete(Breed breed) throws SQLException {
//		String sql = "delete from breed where id = " + breed.getId();
		deletePs.setInt(1, breed.getId());
//		int res = DBConnection.getInstance().executeUpdate(sql);
		int res = deletePs.executeUpdate();
		return res > 0;
	}


	// Unchanged, no parametrized stuff
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
//		String sql = "select id, name, max_weight, description from breed where id = " + id;
//		System.out.println("BreedDB, Query: " + sql);
//		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
		try {
			findByIdPs.setInt(1, id);
			//ResultSet rs = s.executeQuery(sql);
			ResultSet rs = findByIdPs.executeQuery();
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
		
//		String sql = "select id, name, max_weight, description from breed where name like '%" + name + "%'";
//		System.out.println("BreedDB, Query: " + sql);
//		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
//			ResultSet rs = s.executeQuery(sql);
		try {
			findByNamePs.setString(1, "%" + name + "%");
			ResultSet rs = findByNamePs.executeQuery();
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return res;
	}

}
