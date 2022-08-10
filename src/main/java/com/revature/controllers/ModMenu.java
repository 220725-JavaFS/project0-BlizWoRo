package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.MembersInfo;
import com.revature.models.Message;
import com.revature.services.MembersService;
import com.revature.services.MessageServices;

public class ModMenu {
	
	private MessageServices messServ = new MessageServices();
	private MembersService memServ = new MembersService();
	private Scanner scan = new Scanner(System.in);
	
public void modMenu() {
	
	String choice = "";
	
	menuLoop:
		while(!choice.equalsIgnoreCase("0")) {
			
			System.out.println("What would you like to do? "
					+ "Please select from the options below. "
					+ "\n 1. Send a new message."
					+ "\n 2. Count your total messages."
					+ "\n 3. Count total members."
					+ "\n 4. View Current Members."
					+ "\n 0. LogOut");
			
			choice = scan.nextLine();
			switchChoice:
				switch(choice) {
				case "1":
					createMessage();
					break switchChoice;
				case "2":
					countTotalMessage();
					break switchChoice;
				case "3":
					countTotalMember();
					break switchChoice;
				case "4":
					viewMember();
					break switchChoice;
				case "0":
					break switchChoice;
				default:
					System.out.println("Sorry that is not a valid input. Please select again.");
					break switchChoice;
						
				}
		}
		
	}

private void viewMember() {
	String answer ="";
	while(!answer.equalsIgnoreCase("exit")) {
		System.out.println("What would you like to do? "
				+ "\nTo view members by ID, type 'ID'. "
				+ "\nType 'All' to view all members."
				+ "\nType 'EXIT' to exit.");
		answer = scan.nextLine();
		
		if(answer.equalsIgnoreCase("all")) {
			List<MembersInfo> list = memServ.allMembers();
			System.out.println("Here is all the Members: ");
			for(MembersInfo a:list) {
				System.out.println(a);
			}continue;
		}else if(answer.equalsIgnoreCase("exit")) {
			return;
		}else {
			int id = 0;
			
			try {
				id=Integer.parseInt(answer);
			}catch(NumberFormatException e) {
				System.out.println("Not a valid input. Please try again.");
				continue;
			}
			MembersInfo member = memServ.getSingleMember(id);
			System.out.println("Here is your Member: "+ member);
		}
	}
	
}

private void countTotalMember() {
	String answer = "";
	while(!answer.equalsIgnoreCase("exit")) {
		System.out.println("Would you like to see the total member count?"
				+ "\nIf yes type'YES' and if no type 'NO'.");
		answer=scan.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			
			MembersInfo membersCount = memServ.getMembersCount();
			//int addCount = 0;
			System.out.println("If you want a break down list of different "
					+ "member catagories, "
					+ "\ntype 'YES' otherwise type 'EXIT' for no.");
			answer = scan.nextLine();
			if(answer.equalsIgnoreCase("yes")) {
				String choice = "";
				menuLoop:
					while(!choice.equalsIgnoreCase("0")) {
						
						System.out.println("Choose the Category: "
								+ "\n 1. Count of Total Administrators."
								+ "\n 2. Count of Total Moderators."
								+ "\n 3. Count of Total Members."
								+ "\n 0. Exit.");
						choice = scan.nextLine();
						switchChoice:
							switch(choice) {
							case "1":
								totalMod();
								break switchChoice;
							case "2":
								totalReg();
								break switchChoice;
							case "0":
								break switchChoice;
								default:
									System.out.println("This is not a valid input, try again.");
									break switchChoice;
							}
							
						
					}
			}else if(answer.equalsIgnoreCase("no")) {
				return;
			}
		
		} else if(answer.equalsIgnoreCase("no")) {
		System.out.println("OK Good Bye.");
		return;
		}
		
	}
	
	
}

private void countTotalMessage() {
	String answer = "";
	while(!answer.equalsIgnoreCase("exit")) {
		System.out.println("Would you like to see the total member count?"
				+ "\nIf yes type'YES' and if no type 'NO'.");
		answer=scan.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			
			Message messageCount = messServ.getMessageCount();
			System.out.println("The number of Message are: "+messageCount);
		
		} else if(answer.equalsIgnoreCase("no")) {
		System.out.println("OK Good Bye.");
		return;
		}
		
	}
	
}

private void totalReg() {
	String answer = "";
	while(!answer.equalsIgnoreCase("exit")) {
		System.out.println("Would you like to see the total regular member count?"
				+ "\nIf yes type'YES' and if no type 'EXIT'.");
		answer=scan.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			
			MembersInfo regCount = memServ.getMembersRegCount(0, null);
		}
	}
}

private void totalMod() {
	String answer = "";
	while(!answer.equalsIgnoreCase("exit")) {
		System.out.println("Would you like to see the total moderator count?"
				+ "\nIf yes type'YES' and if no type 'EXIT'.");
		answer=scan.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			
			MembersInfo modCount = memServ.getMembersModCount(0, null);
		}
	}
}

private void createMessage() {
	System.out.println("Great! Thank you for using our service. \nPlease let us know about the new message."+
			"\nWhat is the new message?");
			
			Message message = new Message();
			message.setMessage(scan.nextLine());
			
			System.out.println("Who will you send the message to?");
			
			message.seteMail(scan.nextLine());

			messServ.newMessage(message);
	
	
}

//private void seeReceivedMessage() {
//	String answer = "";
//	while (!answer.equalsIgnoreCase("exit")) {
//		System.out.println(
//				"Which message would you like to see? \nPlease give the ID number or type 'ALL' "
//						+ "for all received messages. \nTYPE 'EXIT' to exit.");
//		answer = scan.nextLine();
//		//String eMail = "dH@sight.com";
//		if (answer.equalsIgnoreCase("all")) {
//			List<Message> list = messServ.allMessage();
//			System.out.println("Here are all the messages: ");
//			for(Message a:list){
//				System.out.println(a);// get all messages
//			}
//			continue;
//		} else if (answer.equalsIgnoreCase("exit")) {
//			return;
//		} else {
//			int id = 0;
//
//			try {
//				id = Integer.parseInt(answer);
//			} catch (NumberFormatException e) {
//				System.out.println("That is not a valid id, please try again");
//				continue;
//			}
//
//			Message message = messServ.getSingleMessage(id);
//
//			System.out.println("Here is your message: \n" + message);
//			
//		}
//
//	}
//	
}


