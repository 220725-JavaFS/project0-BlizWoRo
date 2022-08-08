package com.revature.controllers;

import java.util.Scanner;

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
					+ "\n 1. View your received messages."
					+ "\n 2. Send a new message."
					+ "\n 3. Count your total messages."
					+ "\n 4. Count total members."
					+ "\n 5. View Current Members."
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
					countTotalMessage();
					break switchChoice;
				case "4":
					countTotalMember();
					break switchChoice;
				case "5":
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
	// TODO Auto-generated method stub
	
}

private void countTotalMember() {
	// TODO Auto-generated method stub
	
}

private void countTotalMessage() {
	// TODO Auto-generated method stub
	
}

private void createMessage() {
	// TODO Auto-generated method stub
	
}

private void seeReceivedMessage() {
	// TODO Auto-generated method stub
	
}

}
