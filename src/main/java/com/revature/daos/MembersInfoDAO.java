package com.revature.daos;

import com.revature.models.MembersInfo;

public interface MembersInfoDAO {
	
	MembersInfo getMemberByEmail(String eMail);

	static void NewMember(MembersInfo member) {
		// TODO Auto-generated method stub
		
	}

}
