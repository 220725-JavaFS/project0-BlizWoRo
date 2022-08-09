package com.revature.models;

public class LevelMember {
	
	private int memberLevelID;
	private String eMail;
	private boolean administrator;
	private boolean moderator;
	private boolean regMember;
	
	public LevelMember(int memberLevelID, String eMail, boolean administrator, boolean moderator, boolean regMember) {
		super();
		this.memberLevelID = memberLevelID;
		this.eMail = eMail;
		this.administrator = administrator;
		this.moderator = moderator;
		this.regMember = regMember;
	}

	public LevelMember(String eMail, boolean administrator, boolean moderator, boolean regMember) {
		super();
		this.eMail = eMail;
		this.administrator = administrator;
		this.moderator = moderator;
		this.regMember = regMember;
	}

	public LevelMember() {
		super();
	}

	public int getMemberLevelID() {
		return memberLevelID;
	}

	public void setMemberLevelID(int memberLevelID) {
		this.memberLevelID = memberLevelID;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public boolean isRegMember() {
		return regMember;
	}

	public void setRegMember(boolean regMember) {
		this.regMember = regMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (administrator ? 1231 : 1237);
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + memberLevelID;
		result = prime * result + (moderator ? 1231 : 1237);
		result = prime * result + (regMember ? 1231 : 1237);
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
		LevelMember other = (LevelMember) obj;
		if (administrator != other.administrator)
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (memberLevelID != other.memberLevelID)
			return false;
		if (moderator != other.moderator)
			return false;
		if (regMember != other.regMember)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LevelMember [memberLevelID=" + memberLevelID + ", eMail=" + eMail + ", administrator=" + administrator
				+ ", moderator=" + moderator + ", regMember=" + regMember + "]";
	}
	
	

}
