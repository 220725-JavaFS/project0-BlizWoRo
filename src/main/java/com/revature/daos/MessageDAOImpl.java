package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Message;
import com.revature.utils.ConnectionUtil;

public class MessageDAOImpl implements MessageDAO {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public Message getMessageById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "SELECT * FROM Message WHERE messageID = "+id+";";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				Message message = new Message(
					result.getInt("messageID"),
					result.getString("message"),
					result.getString("eMail")
					);

			String eMail = result.getString("eMail");
			
				
				return message;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
	

	@Override
	public List<Message> getAllMessage() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Message;";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			
			List<Message> messageList = new LinkedList<Message>();
			
			while(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				Message message = new Message(
						result.getInt("messageID"),
						result.getString("message"),
						result.getString("eMail")
						);		
				messageList.add(message);
			}
			
			return messageList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void InsertMessage(Message message) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO Message (message, eMail)"
					+ " VALUES (?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			statement.setString(++count, message.getMessage());
			statement.setString(++count, message.geteMail());
			statement.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public Message getMessageByEmail(String eMail) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Message WHERE eMail = " + "'"+eMail+"'" +";";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(sql);
			statement.setString(1,eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			//System.out.println("result: " + result);
			
			if(result.next()) {
				Message message = new Message();
				message.setMessage(result.getString("message"));
				message.seteMail(result.getString("eMail"));
				
				return message;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Message> getAllRecMessage(String eMail) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Message WHERE eMail = '"+eMail+"';";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(sql);
			//statement.setString(1,eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			//System.out.println("result: " + result);
			
			if(result.next()) {
				Message message = new Message();
				message.setMessage(result.getString("message"));
				message.seteMail(result.getString("eMail"));
				
				return message;
			}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Message getCountMessage() {
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "SELECT COUNT(messageID)AS Count FROM Message;";
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
	public List<Message> getYourMessage(String answer, String answer2) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT messageID, message FROM Message "
					+ "JOIN MembersInfo ON Message.eMail = MembersInfo.eMail "
					+ "AND MembersInfo.userName = '"+answer+"' AND MembersInfo.pWord = crypt('"+answer2+"', pWord);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			//statement.setString(1,eMail);//this is where sql injection is checked for.
			
			ResultSet result = statement.executeQuery();
			//System.out.println("result: " + result);
			List<Message> messageList = new LinkedList<Message>();
			
			while(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				Message message = new Message(
						result.getInt("messageID"),
						result.getString("message")
						);		
				messageList.add(message);
			}
			
			return messageList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
