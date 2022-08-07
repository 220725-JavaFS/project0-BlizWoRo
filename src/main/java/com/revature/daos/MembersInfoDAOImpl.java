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
			String sql = "SELECT * FROM MembersInfo WHERE eMail = " + "'"+eMail+"'" +";";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(sql);
			statement.setString(1,eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			//System.out.println("result: " + result);
			
			if(result.next()) {
				MembersInfo member = new MembersInfo();
				member.setFirstName(result.getString("firstName"));
				member.setLastName(result.getString("lastName"));
				member.seteMail(result.getString("eMail"));
				member.setUserName(result.getString("userName"));
				member.setpWord(result.getString("pWord"));
				member.setAdministrator(result.getBoolean("administrator"));
				member.setModerator(result.getBoolean("moderator"));
				member.setRegMember(result.getBoolean("regMember"));
				return member;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
