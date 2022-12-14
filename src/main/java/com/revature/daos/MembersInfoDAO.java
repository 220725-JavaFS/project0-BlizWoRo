package com.revature.daos;

import java.util.List;

import com.revature.models.LevelMember;
import com.revature.models.MembersInfo;

public interface MembersInfoDAO {
	
	MembersInfo getMemberByEmail(String eMail);

	public abstract void NewMember(MembersInfo member, LevelMember level);
	
	public abstract boolean Member (String userName, String pWord);

	public abstract MembersInfo getMemberById(int id);

	List<MembersInfo> getAllMembers();

	public abstract MembersInfo getDeletedMember(int id);

	public abstract MembersInfo getCountMembers();

	public abstract MembersInfo getMemberUpdate(int id, String columnName, String change);

	public abstract boolean getMemberByUserAdmin(String answer, String answer2);

	public abstract boolean getMemberByUserMod(String answer, String answer2);

	public abstract boolean getMemberByUserReg(String answer, String answer2);
	
	public abstract MembersInfo getUpdateFirstName(int id, String change);

	public abstract MembersInfo getUpdateMemberLast(int id, String change);

	public abstract MembersInfo getUpdateEmail(int id, String change);

	public abstract MembersInfo getUpdateUser(int id, String change);

	public abstract MembersInfo getUpdatePass(int id, String change);

	public abstract MembersInfo getRegCount(int count, LevelMember reg);

	public abstract MembersInfo getModCount(int count, LevelMember mod);

	public abstract MembersInfo getAdminCount(int count, LevelMember admin);
	

}
