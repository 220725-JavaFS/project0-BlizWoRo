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
}