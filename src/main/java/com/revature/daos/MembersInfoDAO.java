package com.revature.daos;

import com.revature.models.MembersInfo;

public interface MembersInfoDAO {
	
	MembersInfo getMemberByEmail(String eMail);

	public abstract void NewMember(MembersInfo member);
	
	public abstract boolean Member (String userName, String pWord);
	
	

}
