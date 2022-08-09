package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.LevelMember;
import com.revature.utils.ConnectionUtil;

public class LevelMemberDAOImpl implements LevelMemberDAO {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public LevelMember getMemberByEmail(String eMail, boolean admin, boolean moder, boolean reg) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE LevelMember SET administrator = "+admin+", moderator = "+moder+", regMember = "+reg+" WHERE eMail = '"+eMail+"';";
			PreparedStatement prepares = conn.prepareStatement(sql);
		
			prepares.execute();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getLevelByEmail(String eMail) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM LevelMember WHERE eMail = " + "'"+eMail+"'" +";";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(sql);
			statement.setString(1,eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			//System.out.println("result: " + result);
			
			if(result.next()) {
				LevelMember level = new LevelMember();
				level.setMemberLevelID(result.getInt("memberLevelID"));
				level.seteMail(result.getString("eMail"));
				level.setAdministrator(result.getBoolean("administrator"));
				level.setModerator(result.getBoolean("moderator"));
				level.setRegMember(result.getBoolean("regMember"));
				
				return level;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean getLevelByAdmin(boolean admin) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM LevelMember WHERE administrator = true ;";
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

	@Override
	public boolean getLevelByMod(boolean mod) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM LevelMember WHERE moderator = true ;";
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

	@Override
	public boolean getLevelByReg(boolean reg) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM LevelMember WHERE regMember = true ;";
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
