package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.MembersInfo;
import com.revature.utils.ConnectionUtil;

public class MembersInfoDAOImpl implements MembersInfoDAO {

	@Override
	public MembersInfo getMemberByEmail(String eMail) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo WHERE eMail = " + eMail +";";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				MembersInfo member = new MembersInfo();
				member.setFirstName(result.getString("home_name"));
				member.setLastName(result.getString("str_num"));
				member.seteMail(result.getString("str_name"));
				member.setUserName(result.getString("city"));
				member.setpWord(result.getString("state"));
				member.setAdministrator(result.getBoolean("zip"));
				member.setModerator(result.getBoolean("zip"));
				member.setRegMember(result.getBoolean("zip"));
				return member;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
