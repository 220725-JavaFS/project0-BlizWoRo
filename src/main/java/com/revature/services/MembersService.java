package com.revature.services;

import java.util.List;

import com.revature.daos.MembersInfoDAO;
import com.revature.daos.MembersInfoDAOImpl;
import com.revature.models.LevelMember;
import com.revature.models.MembersInfo;

public class MembersService {
	
	private MembersInfoDAO membersDAO = new MembersInfoDAOImpl();
	
	public List<MembersInfo> allMembers;
	
	public void newMember(MembersInfo member, LevelMember level) {
		membersDAO.NewMember(member, level);
	}
	
	public boolean getMemberByUser (String userName, String pWord) {
		return membersDAO.Member(userName,pWord);
		
	}

	public MembersInfo getSingleMember(int id) {
		return membersDAO.getMemberById(id);
		
	}

	public List<MembersInfo> allMembers() {
		return membersDAO.getAllMembers();
	}

	public MembersInfo getDeleteMember(int id) {
		return membersDAO.getDeletedMember(id);
		
	}

	public MembersInfo getMembersCount() {
		
		return membersDAO.getCountMembers();
	}

	public MembersInfo getUpdateMember(int id, String columnName, String change) {
		
		return membersDAO.getMemberUpdate(id, columnName, change);
	}

	public Object getMemberByEmail(String eMail) {
		return membersDAO.getMemberByEmail(eMail);
		
	}

	public boolean getMemberByUserAdmin(String answer, String answer2) {
		return membersDAO.getMemberByUserAdmin(answer, answer2);
	}

	public boolean getMemberByUserMod(String answer, String answer2) {
		return membersDAO.getMemberByUserMod(answer, answer2);
		
	}

	public boolean getMemberByUserReg(String answer, String answer2) {
		return membersDAO.getMemberByUserReg(answer, answer2);
		
	}
	public MembersInfo getUpdateMemberFirst(int id, String change) {
		return membersDAO.getUpdateFirstName(id, change);
		
	}

	public MembersInfo getUpdateMemberLast(int id, String change) {
		return membersDAO.getUpdateMemberLast(id, change);
	}

	public MembersInfo getUpdateMembereMail(int id, String change) {
		return membersDAO.getUpdateEmail(id, change);
	}

	public MembersInfo getUpdateMemberUser(int id, String change) {
		return membersDAO.getUpdateUser(id, change);
	}

	public MembersInfo getUpdateMemberPass(int id, String change) {
		return membersDAO.getUpdatePass(id, change);
	}

	public MembersInfo getMembersRegCount(int count, LevelMember reg) {
		return membersDAO.getRegCount(count, reg);
	}

	public MembersInfo getMembersModCount(int count, LevelMember mod) {
		return membersDAO.getModCount(count, mod);
	}

	public MembersInfo getMembersAdminCount(int count, LevelMember admin) {
		return membersDAO.getAdminCount(count, admin);
	}
}