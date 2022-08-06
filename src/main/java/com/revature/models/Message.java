package com.revature.models;

public class Message {
	
	private int messageID;
	private String messageSend;
	private String messageRec;
	private MembersInfo eMailrec;
	private MembersInfo eMailsend;
	
	public Message(int messageID, String messageSend, String messageRec, MembersInfo eMailrec, MembersInfo eMailsend) {
		super();
		this.messageID = messageID;
		this.messageSend = messageSend;
		this.messageRec = messageRec;
		this.eMailrec = eMailrec;
		this.eMailsend = eMailsend;
	}

	public Message(String messageSend, String messageRec, MembersInfo eMailrec, MembersInfo eMailsend) {
		super();
		this.messageSend = messageSend;
		this.messageRec = messageRec;
		this.eMailrec = eMailrec;
		this.eMailsend = eMailsend;
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

	public String getMessageSend() {
		return messageSend;
	}

	public void setMessageSend(String messageSend) {
		this.messageSend = messageSend;
	}

	public String getMessageRec() {
		return messageRec;
	}

	public void setMessageRec(String messageRec) {
		this.messageRec = messageRec;
	}

	public MembersInfo geteMailrec() {
		return eMailrec;
	}

	public void seteMailrec(MembersInfo eMailrec) {
		this.eMailrec = eMailrec;
	}

	public MembersInfo geteMailsend() {
		return eMailsend;
	}

	public void seteMailsend(MembersInfo eMailsend) {
		this.eMailsend = eMailsend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMailrec == null) ? 0 : eMailrec.hashCode());
		result = prime * result + ((eMailsend == null) ? 0 : eMailsend.hashCode());
		result = prime * result + messageID;
		result = prime * result + ((messageRec == null) ? 0 : messageRec.hashCode());
		result = prime * result + ((messageSend == null) ? 0 : messageSend.hashCode());
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
		if (eMailrec == null) {
			if (other.eMailrec != null)
				return false;
		} else if (!eMailrec.equals(other.eMailrec))
			return false;
		if (eMailsend == null) {
			if (other.eMailsend != null)
				return false;
		} else if (!eMailsend.equals(other.eMailsend))
			return false;
		if (messageID != other.messageID)
			return false;
		if (messageRec == null) {
			if (other.messageRec != null)
				return false;
		} else if (!messageRec.equals(other.messageRec))
			return false;
		if (messageSend == null) {
			if (other.messageSend != null)
				return false;
		} else if (!messageSend.equals(other.messageSend))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", messageSend=" + messageSend + ", messageRec=" + messageRec
				+ ", eMailrec=" + eMailrec + ", eMailsend=" + eMailsend + "]";
	}
	
}
