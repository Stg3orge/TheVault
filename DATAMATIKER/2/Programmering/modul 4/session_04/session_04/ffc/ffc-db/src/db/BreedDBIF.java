package db;

import java.sql.SQLException;
import java.util.List;

import model.Breed;

public interface BreedDBIF {
	Breed create(Breed breed) throws SQLException;
	Breed update(Breed breed) throws SQLException;
	boolean delete(Breed breed) throws SQLException;
	List<Breed> getAll() throws SQLException;
	Breed findById(int id) throws SQLException;
	List<Breed> findByName(String name) throws SQLException;
}
