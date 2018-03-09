package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Breed;
import model.Dog;

public class DogDB implements DogDBIF{

	@Override
	public Dog findById(int id, boolean retrieveAssociation) throws SQLException {
		String sql = "select id, name, fee_year, breed_id from dog where id = " + id;
		System.out.println("DogDB, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			Dog dog = null;
			if(rs.next()) {
				dog = buildObject(rs);
				
				// follow the association!
				if(retrieveAssociation) {
					Breed breed = new BreedDB().findById(dog.getBreed().getId());
					// had BreedDB.findById(...) had a "retrieveAssociation" option, it should have been set to false!
					dog.setBreed(breed); // change the empty Breed to a full one.
				}
			}
			return dog;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public Dog create(String name, int feeYear, int memberId, int breedId) throws SQLException	{
		Dog d = null;
		try {
			String sql = String.format("insert into dog (name, fee_year, member_id, breed_id) " 
						+ "values ('%s', %d, %d, %d)", name, feeYear, memberId, breedId);
			int id = DBConnection.getInstance().executeInsertWithIdentity(sql);
			Breed breed = new BreedDB().findById(breedId);
			d = new Dog(name, feeYear, breed);
			d.setId(id);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return d;
	}
	
	@Override
	public Dog update(int id, String name, int feeYear, int memberId, int breedId) throws SQLException {
		String sql[] = new String[4];
		sql[0] = String.format("update dog set name = '%s' where id = %d", name, id);
		sql[1] = String.format("update dog set fee_year = %d where id = %d", feeYear, id);
		sql[2] = String.format("update dog set member_id = %d where id = %d", memberId, id);
		sql[3] = String.format("update dog set breed_id = %d where id = %d", breedId, id);
		Dog res = null;
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			for(int i = 0; i < sql.length; i++) {
				s.executeUpdate(sql[i]);
			}
			res = this.findById(id, true);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	@Override
	public boolean delete(int id) throws SQLException {
		String sql = String.format("delete from dog where id = %d", id);
		int res = -1;
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			res = s.executeUpdate(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res == 1;
	}
	@Override
	public List<Dog> findAll() throws SQLException {
		String sql = "select * from dog";
		List<Dog> res = null;
		try (Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return res;
	}
	
	@Override
	public List<Dog> findByName(String name) throws SQLException {
		String sql = String.format("select * from dog where name like '%%%s%%'", name);
		List<Dog> res = null;
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return res;
	}
	
	@Override
	public List<Dog> findByMemberId(int memberId) throws SQLException {
		String sql = String.format("select * from dog where member_id = %d", memberId);
		List<Dog> res = null;
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return res;
	}

	private Dog buildObject(ResultSet rs) throws SQLException {
		Dog d = new Dog();
		d.setId(rs.getInt("id"));
		d.setName(rs.getString("name"));
		d.setFeeYear(rs.getInt("fee_year"));
		Breed breed = new Breed();
		breed.setId(rs.getInt("breed_id"));
		d.setBreed(breed);
		return d;
	}
	
	private List<Dog> buildObjects(ResultSet rs) throws SQLException {
		List<Dog> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}

}
