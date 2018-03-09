package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
