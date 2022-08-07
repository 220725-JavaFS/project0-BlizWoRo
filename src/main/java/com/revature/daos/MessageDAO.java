package com.revature.daos;

import java.util.List;

import com.revature.models.Message;

public interface MessageDAO {
	
public abstract Message getMessageById(int id);
	
	List<Message> getAllMessage();

public abstract void InsertMessage(Message message);

}
