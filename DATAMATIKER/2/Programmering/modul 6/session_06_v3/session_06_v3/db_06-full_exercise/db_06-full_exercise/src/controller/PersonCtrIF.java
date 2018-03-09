package controller;

import java.time.LocalDate;
import java.util.List;

import db.HorribleException;
import model.Person;

public interface PersonCtrIF {

	List<Person> findAll() throws HorribleException;

	Person findById(int id) throws HorribleException;

	void updatePerson(int id, String name, String email, String phone, LocalDate birthDate, int groupId)
			throws HorribleException;

}