package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.models.MembersInfo;
import com.revature.models.Message;
import com.revature.utils.ConnectionUtil;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public Message getMessageById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM avengers WHERE hero_id = " + id +"; ";
			Statement statement = conn.createStatement(); 
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				//results sets are cursor base, each time .next is called the cursor moves to the next group of values. 
				//It starts the one before so you will always need to call the next.
				
				Message message = new Message(
						result.getInt("messageID"),
						result.getString("messageSend"),
						result.getString("messageRec")
						);
				
				String eMailrec = result.getString("eMailrec");
				if(eMailrec !=null) {
					MembersInfoDAO memberinfoDAO = new MembersInfoDAOImpl();
					MembersInfo member = memberinfoDAO.getMemberByEmail(eMailrec);
					message.seteMailrec(member);
				}
				
				return message;
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
