package com.revature.services;

import java.util.List;


import com.revature.daos.MessageDAO;
import com.revature.daos.MessageDAOImpl;
import com.revature.models.MembersInfo;
import com.revature.models.Message;

public class MessageServices {
	
	private MessageDAO messageDAO = new MessageDAOImpl();

	public Message geteMailMessage (String eMail) {
		return messageDAO.getMessageByEmail(eMail);
	}
	
	public Message getSingleMessage (int id) {
		return messageDAO.getMessageById(id);
	}
	
	public List<Message> allMessage(){
		return messageDAO.getAllMessage();
	}
	public List<Message> allRecMessage(String eMail){
		return messageDAO.getAllRecMessage(eMail);
	}

	public void newMessage(Message message) {
		messageDAO.InsertMessage(message);

	}

	public Message getMessageCount() {
		return messageDAO.getCountMessage();
	}

	public List<Message> yourMessage(String answer, String answer2) {
		return messageDAO.getYourMessage(answer, answer2);
	}

	
	
}
