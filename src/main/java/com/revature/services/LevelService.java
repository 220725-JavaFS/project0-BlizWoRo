package com.revature.services;

import com.revature.daos.LevelMemberDAO;
import com.revature.daos.LevelMemberDAOImpl;
import com.revature.models.LevelMember;

public class LevelService {
	
	private LevelMemberDAO levelDAO = new LevelMemberDAOImpl();

	public LevelMember getMemberLevel(String eMail, boolean admin, boolean moder, boolean reg) {
		return levelDAO.getMemberByEmail(eMail, admin, moder, reg);
		
	}

	public Object getLevelByEmail(String eMail) {
		return levelDAO.getLevelByEmail(eMail);
		
	}

	public boolean getLevelByAdmin(boolean admin) {
		return levelDAO.getLevelByAdmin(admin);
	}

	public boolean getLevelByMod(boolean mod) {
		return levelDAO.getLevelByMod(mod);
		
	}

	public boolean getLevelByReg(boolean reg) {
		return levelDAO.getLevelByReg(reg);
		
	}
	
	

}
