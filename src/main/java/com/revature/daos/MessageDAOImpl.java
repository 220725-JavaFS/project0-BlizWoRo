package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import com.revature.models.Message;
import com.revature.utils.ConnectionUtil;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public Message getMessageById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){

			String sql = "SELECT * FROM Message WHERE messageID= "+id+";";
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

}
