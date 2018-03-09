package db;

import java.sql.SQLException;
import java.util.List;

import model.Member;

public interface MemberDBIF {
	public Member create(String name, String email, String phone) throws SQLException;
	public Member update(int id, String name, String email, String phone) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public Member findById(int id, boolean retrieveAssociation) throws SQLException;
	public List<Member> findAll() throws SQLException;
	public boolean removeDog(int memberId, int dogId) throws SQLException;
	
}
