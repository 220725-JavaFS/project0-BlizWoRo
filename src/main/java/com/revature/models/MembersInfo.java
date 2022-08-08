package com.revature.models;

public class MembersInfo {
	
	private int memberID;
	private String firstName;
	private String lastName;
	private String eMail;
	private String userName; 
	private String pWord; 
	private Boolean administrator; 
	private Boolean moderator;
	private Boolean regMember;
	
	public MembersInfo(int memberID, String firstName, String lastName, String eMail, String userName, String pWord,
			Boolean administrator, Boolean moderator, Boolean regMember) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.userName = userName;
		this.pWord = pWord;
		this.administrator = administrator;
		this.moderator = moderator;
		this.regMember = regMember;
	}

	public MembersInfo(String firstName, String lastName, String eMail, String userName, String pWord,
			Boolean administrator, Boolean moderator, Boolean regMember) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.userName = userName;
		this.pWord = pWord;
		this.administrator = administrator;
		this.moderator = moderator;
		this.regMember = regMember;
	}

	public MembersInfo() {
		super();
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public Boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	public Boolean isModerator() {
		return moderator;
	}

	public void setModerator(Boolean moderator) {
		this.moderator = moderator;
	}

	public Boolean isRegMember() {
		return regMember;
	}

	public void setRegMember(Boolean regMember) {
		this.regMember = regMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrator == null) ? 0 : administrator.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + memberID;
		result = prime * result + ((moderator == null) ? 0 : moderator.hashCode());
		result = prime * result + ((pWord == null) ? 0 : pWord.hashCode());
		result = prime * result + ((regMember == null) ? 0 : regMember.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		MembersInfo other = (MembersInfo) obj;
		if (administrator == null) {
			if (other.administrator != null)
				return false;
		} else if (!administrator.equals(other.administrator))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (memberID != other.memberID)
			return false;
		if (moderator == null) {
			if (other.moderator != null)
				return false;
		} else if (!moderator.equals(other.moderator))
			return false;
		if (pWord == null) {
			if (other.pWord != null)
				return false;
		} else if (!pWord.equals(other.pWord))
			return false;
		if (regMember == null) {
			if (other.regMember != null)
				return false;
		} else if (!regMember.equals(other.regMember))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MembersInfo [memberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail="
				+ eMail + ", userName=" + userName + ", pWord=" + pWord + ", administrator=" + administrator
				+ ", moderator=" + moderator + ", regMember=" + regMember + "]";
	}

}
