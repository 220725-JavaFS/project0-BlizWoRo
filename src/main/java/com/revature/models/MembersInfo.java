package com.revature.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MembersInfo implements List<MembersInfo>{
	
	private int memberID;
	private String firstName;
	private String lastName;
	public MembersInfo(int memberID, String firstName, String lastName, String eMail) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

	public MembersInfo(int memberID, String firstName, String lastName, String eMail, LevelMember levelmem) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.levelmem = levelmem;
	}

	private String eMail;
	private String userName; 
	
	public LevelMember getLevelmem() {
		return levelmem;
	}

	public void setLevelmem(LevelMember levelmem) {
		this.levelmem = levelmem;
	}

	private String pWord;
	private LevelMember levelmem;
	
	public MembersInfo(int memberID, String firstName, String lastName, String eMail, String userName, String pWord) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.userName = userName;
		this.pWord = pWord;
	}

	public MembersInfo(String firstName, String lastName, String eMail, String userName, String pWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.userName = userName;
		this.pWord = pWord;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + memberID;
		result = prime * result + ((pWord == null) ? 0 : pWord.hashCode());
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
		if (pWord == null) {
			if (other.pWord != null)
				return false;
		} else if (!pWord.equals(other.pWord))
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
				+ eMail + ", userName=" + userName + ", pWord=" + pWord + "]";
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<MembersInfo> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(MembersInfo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends MembersInfo> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends MembersInfo> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MembersInfo get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembersInfo set(int index, MembersInfo element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, MembersInfo element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MembersInfo remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<MembersInfo> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<MembersInfo> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembersInfo> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
