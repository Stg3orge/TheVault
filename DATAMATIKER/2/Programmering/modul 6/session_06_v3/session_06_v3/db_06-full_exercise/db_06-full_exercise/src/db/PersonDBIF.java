package db;

import java.time.LocalDate;
import java.util.List;

import model.Person;

public interface PersonDBIF {
	List<Person> findAll() throws HorribleException;
	Person findById(int id) throws HorribleException;
	void update(int id, String name, String email, String phone, LocalDate birthDate, int groupId) throws HorribleException;
}
