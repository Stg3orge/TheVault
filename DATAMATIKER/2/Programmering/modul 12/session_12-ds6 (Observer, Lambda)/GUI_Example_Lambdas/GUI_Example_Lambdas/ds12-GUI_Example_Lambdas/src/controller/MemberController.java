package controller;

import java.util.List;

import model.Member;
import model.MemberContainer;

public class MemberController {
	public Member createMember(String name, int since) {
		Member m = new Member();
		m.setName(name);
		m.setSince(since);
		MemberContainer.getInstance().addMember(m);
		//now, m has an ID
		return m;
	}
	
	public Member findMemberById(int id) {
		return MemberContainer.getInstance().findMemberById(id);
	}
	
	public Member removeMemberById(int id) {
		return MemberContainer.getInstance().removeMemberById(id);
	}
	
	public List<Member> getAll() {
		return MemberContainer.getInstance().getAll();
	}
	
	public boolean updateMember(int id, String name, int since) {
		Member m = MemberContainer.getInstance().findMemberById(id);
		if(m == null) {
			return false;
		}
		m.setName(name);
		m.setSince(since);
		return true;
	}
}	
