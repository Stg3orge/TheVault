package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Dog;

public interface DogDBIF {
	public Dog findById(int id, boolean retrieveAssociation) throws SQLException;
	
	public Dog create(String name, int feeYear, int memberId, int breedId) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public List<Dog> findAll() throws SQLException;
	public List<Dog> findByName(String name) throws SQLException;
	public List<Dog> findByMemberId(int memberId) throws SQLException ;
	public Dog update(int id, String name, int feeYear, int memberId, int breedId) throws SQLException;
}
