package controller;

import java.sql.SQLException;

import db.DBConnection;
import db.DogDB;
import db.MemberDB;
import model.Dog;
import model.Member;

/*
 * This example is kept simple TO DEMO TRANSAACTIONS IN A DAO FRAMEWORK, you should really use interfaces for the db-classes and controllers
 */
public class MemberController {
	public Member createMemberAndDog(String memberName, String phone, String email, String dogName, int feeYear, int breedId) throws SQLException {
		Member res = null;
		DBConnection.getInstance().startTransaction();
		try {
			res = new MemberDB().create(memberName, email, phone);
			Dog d = new DogDB().create(dogName, feeYear, res.getId(), breedId);
			res.addDog(d);
			DBConnection.getInstance().commitTransaction();
		}
		catch(SQLException e) {
			DBConnection.getInstance().rollbackTransaction();
			throw e;
		}
		return res;
	}
}
