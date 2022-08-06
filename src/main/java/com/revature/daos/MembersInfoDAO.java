package com.revature.daos;

import com.revature.models.MembersInfo;

public interface MembersInfoDAO {
	
	MembersInfo getMemberByEmail(String eMail);

}
