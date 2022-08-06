package com.revature.services;

import java.util.List;


import com.revature.daos.MessageDAO;
import com.revature.daos.MessageDAOImpl;
import com.revature.models.Message;

public class MessageServices {
	
	private MessageDAO messageDAO = new MessageDAOImpl();

	public Message getSingleMessage (int id) {
		return messageDAO.getMessageById(id);
	}
	
	public List<Message> allMessage(){
		return messageDAO.getAllMessage();
	}

	public void newMessage(Message message) {
		messageDAO.InsertMessage(message);

	}
}
