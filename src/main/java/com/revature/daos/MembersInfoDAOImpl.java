package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	@Override
	public void NewMember(MembersInfo member) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO MembersInfo (firstName, lastName, eMail, userName, pWord, administrator, moderator, regMember)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setString(++count, member.getFirstName());
			statement.setString(++count, member.getLastName());
			statement.setString(++count, member.geteMail());
			statement.setString(++count, member.getUserName());
			statement.setString(++count, member.getpWord());
			if(member.isAdministrator()!=null) {
				statement.setBoolean(++count, member.isAdministrator());
			}
			if(member.isModerator()!=null) {
				statement.setBoolean(++count, member.isModerator());
			}
			if(member.isRegMember()!=null) {
				statement.setBoolean(++count, member.isRegMember());	
			}
			
			statement.execute();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean Member(String userName, String pWord) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo WHERE userName = '"+userName+"' AND pWord ='"+pWord+"';";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
			return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}

	
	
		
}



