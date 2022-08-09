package com.revature.daos;

import com.revature.models.LevelMember;

public interface LevelMemberDAO {

	public abstract LevelMember getMemberByEmail(String eMail, boolean admin, boolean moder, boolean reg);

	public abstract Object getLevelByEmail(String eMail);

	public abstract boolean getLevelByAdmin(boolean admin);

	public abstract boolean getLevelByMod(boolean mod);

	public abstract boolean getLevelByReg(boolean reg);

}
