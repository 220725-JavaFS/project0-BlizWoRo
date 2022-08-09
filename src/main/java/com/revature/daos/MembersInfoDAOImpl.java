package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.LevelMember;
import com.revature.models.MembersInfo;
import com.revature.utils.ConnectionUtil;

public class MembersInfoDAOImpl implements MembersInfoDAO {

	private Scanner scan = new Scanner(System.in);
	
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
				
				return member;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void NewMember(MembersInfo member, LevelMember level) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "BEGIN; "
					+ "INSERT INTO MembersInfo "
					+ "(firstName, lastName, eMail, userName, pWord) "
					+ "VALUES (?, ?, ?, ?, ?); "
					+ "INSERT INTO LevelMember (eMail) "
					+ "VALUES (?); "
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setString(++count, member.getFirstName());
			statement.setString(++count, member.getLastName());
			statement.setString(++count, member.geteMail());
			statement.setString(++count, member.getUserName());
			statement.setString(++count, member.getpWord());
			statement.setString(++count, level.geteMail());
			
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

	@Override
	public MembersInfo getMemberById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "SELECT * FROM MembersInfo WHERE memberID = "+id+";";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			//System.out.println(result);
			if(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				MembersInfo member = new MembersInfo(
					result.getInt("memberID"),
					result.getString("firstName"),
					result.getString("lastName"), 
					result.getString("eMail"), 
					result.getString("userName"), 
					result.getString("pWord")
					);

			//String eMail = result.getString("eMail");
			
				
				return member;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<MembersInfo> getAllMembers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo LEFT JOIN LevelMember ON "
					+ "MembersInfo.eMail = LevelMember.eMail;";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			System.out.println(result);
			List<MembersInfo> membersList = new LinkedList<MembersInfo>();
			
			while(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				MembersInfo members = new MembersInfo(
						result.getInt("memberID"),
						result.getString("firstName"),
						result.getString("lastName"), 
						result.getString("eMail"), 
						result.getString("userName"), 
						result.getString("pWord")
						);	
				
				String email = result.getString("eMail");
				if(email !=null) {
					
					LevelMember levelmem = new LevelMember();
					levelmem.seteMail(email);
					levelmem.setMemberLevelID(result.getInt("memberLevelID"));
					levelmem.setAdministrator(result.getBoolean("administrator"));
					levelmem.setModerator(result.getBoolean("moderator"));
					levelmem.setRegMember(result.getBoolean("regMember"));
					members.setLevelmem(levelmem);
				}
				membersList.add(members);
			}
			
			return membersList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MembersInfo getDeletedMember(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM MembersInfo WHERE memberID = "+id+";"; 
			PreparedStatement prepares = conn.prepareStatement(sql);
		
			prepares.execute();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public MembersInfo getCountMembers() {
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "SELECT COUNT(memberID)AS Count FROM MembersInfo;";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			//System.out.println(result);
			result.next();
			int count = result.getInt(1);
			
			System.out.println("The total count is: "+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		}

	@Override
	public MembersInfo getMemberUpdate(int id, String columnName, String change) {
		
	//	int affectedRow = 1;
		
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "UPDATE MembersInfo SET "+columnName+" = '"+change+"' WHERE memberID = "+id+";";
			PreparedStatement prepares = conn.prepareStatement(sql); 
			
			System.out.println(columnName);
			System.out.println(change);
			System.out.println(id);

			//String eMail = result.getString("eMail");
			prepares.execute();

			}
			
		catch(SQLException e) {
			e.printStackTrace();
		
		}
		return null;
	}

	@Override
	public boolean getMemberByUserAdmin(String answer, String answer2) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo JOIN LevelMember ON "
					+ "MembersInfo.eMail = LevelMember.eMail WHERE "
					+ "MembersInfo.userName = '"+answer+"' AND MembersInfo.pWord = '"+answer2+"' "
							+ "AND LevelMember.administrator = TRUE;";
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
	public boolean getMemberByUserMod(String answer, String answer2) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo JOIN LevelMember ON "
					+ "MembersInfo.eMail = LevelMember.eMail WHERE "
					+ "MembersInfo.userName = '"+answer+"' AND MembersInfo.pWord = '"+answer2+"' "
							+ "AND LevelMember.moderator = TRUE;";
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
	public boolean getMemberByUserReg(String answer, String answer2) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM MembersInfo JOIN LevelMember ON "
					+ "MembersInfo.eMail = LevelMember.eMail WHERE "
					+ "MembersInfo.userName = '"+answer+"' AND MembersInfo.pWord = '"+answer2+"' "
							+ "AND LevelMember.regMember = TRUE;";
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
	




