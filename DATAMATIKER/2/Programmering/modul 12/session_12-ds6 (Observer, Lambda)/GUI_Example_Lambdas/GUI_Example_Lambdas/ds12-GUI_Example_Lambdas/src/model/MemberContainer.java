package model;

import java.util.ArrayList;
import java.util.List;

public class MemberContainer {
	private List<Member> members;
	private static MemberContainer instance;
	private int nextId;
	
	private MemberContainer() {
		this.members = new ArrayList<Member>();
	}
	
	public static MemberContainer getInstance() {
		if(instance == null)
			instance = new MemberContainer();
		return instance;
	}
	
	public void addMember(Member m) {
		if(m != null) {
			m.setId(++nextId);
		}
		this.members.add(m);
	}
	
	public Member findMemberById(int id) {
		for(Member m : members) {
			if(m.getId() == id)
				return m;
		}
		return null;
	} 
	
	public Member removeMemberById(int id) {
		Member m = null;
		for(int i = 0 ; i < members.size(); i++) {
			if(members.get(i).getId() == id) {
				m = members.remove(i);
			}
		}
		return m;
	}
	
	public List<Member> getAll()  {
		return new ArrayList<Member>(members);
	}
}
