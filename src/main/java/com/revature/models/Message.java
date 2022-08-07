package com.revature.models;

public class Message {
	
	private int messageID;
	private String message;
	private String eMail;
	
	public Message(int messageID, String message, String eMail) {
		super();
		this.messageID = messageID;
		this.message = message;
		this.eMail = eMail;
	}
	public Message(String message, String eMail) {
		super();
		this.message = message;
		this.eMail = eMail;
	}
	public Message() {
		super();
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + messageID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageID != other.messageID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", message=" + message + ", eMail=" + eMail + "]";
	}
	
	
}
