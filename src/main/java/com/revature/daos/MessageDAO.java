package com.revature.daos;

import java.util.List;

import com.revature.models.MembersInfo;
import com.revature.models.Message;

public interface MessageDAO {
	
public abstract Message getMessageById(int id);
	
	List<Message> getAllMessage();

public abstract void InsertMessage(Message message);

Message getMessageByEmail(String eMail);

public abstract List<Message> getAllRecMessage(String eMail);

public abstract Message getCountMessage();

public abstract List<Message> getYourMessage(String answer, String answer2);


}
