package com.revature.services;

import com.revature.daos.MembersInfoDAO;
import com.revature.daos.MembersInfoDAOImpl;

import com.revature.models.MembersInfo;

public class MembersService {
	
	private MembersInfoDAO membersDAO = new MembersInfoDAOImpl();
	
	public void newMember(MembersInfo member) {
		membersDAO.NewMember(member);
	}
	
	public boolean getMemberByUser (String userName, String pWord) {
		return membersDAO.Member(userName,pWord);
		
	}
}