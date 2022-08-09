package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.MembersInfo;
import com.revature.models.Message;
import com.revature.services.MembersService;
import com.revature.services.MessageServices;

public class RegMenu {
	
	private MessageServices messServ = new MessageServices();
	private MembersService memServ = new MembersService();
	private Scanner scan = new Scanner(System.in);
	
	public void regMenu() {
		
String choice = "";
		
		menuLoop:
			while(!choice.equalsIgnoreCase("0")) {
				
				System.out.println("What would you like to do? "
						+ "Please select from the options below. "
						+ "\n 1. View your received messages."
						+ "\n 2. Send a new message."
						+ "\n 3. View Current Members."
						+ "\n 0. Exit");
				
				choice = scan.nextLine();
				switchChoice:
					switch(choice) {
					case "1":
						seeReceivedMessage();
						break switchChoice;
					case "2":
						createMessage();
						break switchChoice;
					case "3":
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

	private void createMessage() {
		System.out.println("Great! Thank you for using our service. \nPlease let us know about the new message."+
				"\nWhat is the new message?");
				
				Message message = new Message();
				message.setMessage(scan.nextLine());
				
				System.out.println("Who will you send the message to?");
				
				message.seteMail(scan.nextLine());

				messServ.newMessage(message);
		
	}

	private void seeReceivedMessage() {
		String answer = "";
		while (!answer.equalsIgnoreCase("exit")) {
			System.out.println(
					"Which message would you like to see? \nPlease give the ID number or type 'ALL' "
							+ "for all received messages. \nTYPE 'EXIT' to exit.");
			answer = scan.nextLine();
			//String eMail = "dH@sight.com";
			if (answer.equalsIgnoreCase("all")) {
				List<Message> list = messServ.allMessage();
				System.out.println("Here are all the messages: ");
				for(Message a:list){
					System.out.println(a);// get all messages
				}
				continue;
			} else if (answer.equalsIgnoreCase("exit")) {
				return;
			} else {
				int id = 0;

				try {
					id = Integer.parseInt(answer);
				} catch (NumberFormatException e) {
					System.out.println("That is not a valid id, please try again");
					continue;
				}

				Message message = messServ.getSingleMessage(id);

				System.out.println("Here is your message: \n" + message);
				
			}

		}
		
	}

}
