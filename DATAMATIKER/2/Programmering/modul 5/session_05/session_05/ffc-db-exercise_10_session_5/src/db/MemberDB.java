package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Breed;
import model.Dog;
import model.Member;

public class MemberDB implements MemberDBIF {
	
	@Override
	public Member create(String name, String email, String phone) throws SQLException {
		String sql = String.format("insert into member (name, email, phone) values " +
					"('%s', '%s', '%s')", name, email, phone);
		Member res = null;
		try {
			int id = DBConnection.getInstance().executeInsertWithIdentity(sql);
			res = findById(id, false);
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}

	@Override
	public Member update(int id, String name, String email, String phone) throws SQLException {
		String sql[] = new String[3];
		sql[0] = String.format("update member set name = '%s' where id = %d", name, id);
		sql[1] = String.format("update member set email = '%s' where id = %d", email, id);
		sql[2] = String.format("update member set phone = '%s' where id = %d", phone, id);
		Member res = null;
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
		String sql = String.format("delete from member where id = %d", id);
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
	public Member findById(int id, boolean retrieveAssociation) throws SQLException {
		String sql = 
		"select member.id, dog.id as dog_id, dog.name as dname, member.name as name, email, phone from (member left outer join dog on member.id = dog.member_id) where member.id = " + id;
		System.out.println(sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			Member member = null;
			if(rs.next()) {
				member = buildObject(rs);
				do{
					int dogId = rs.getInt("dog_id");
					if(dogId != 0) {
						Dog d = new Dog();
						d.setId(dogId);
						member.addDog(d);
					}
				} while(rs.next());
				// follow the association!
				if(retrieveAssociation) {
					List<Dog> dogs = new DogDB().findByMemberId(member.getId());
					member.setDogs(dogs);
				}
			}
			return member;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Member> findAll() throws SQLException {
		String sql = "select member.id, dog.id as dog_id, dog.name as dname, member.name as name, email, phone from (member left outer join dog on member.id = dog.member_id)";
		List<Member> res = new ArrayList<>();
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			Member m = null;
			int memberId = -1;
			while(rs.next()) {
				if(rs.getInt("id") != memberId ) {
					memberId = rs.getInt("id");
					m = buildObject(rs);
					res.add(m);
				}
				int dogId = rs.getInt("dog_id");
				if(dogId > 0) {
					Dog d = new Dog();
					d.setId(dogId);
					m.addDog(d);
				}
			}
		}
		return res;
	}

	@Override
	public boolean removeDog(int memberId, int dogId) throws SQLException {
		return new DogDB().delete(dogId);

	}
	
	private Member buildObject(ResultSet rs) throws SQLException {
		Member m = new Member();
		m.setId(rs.getInt("id"));
		m.setName(rs.getString("name"));
		m.setEmail(rs.getString("email"));
		m.setPhone(rs.getString("phone"));
		return m;
	}

}
