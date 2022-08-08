package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.MembersInfo;
import com.revature.services.MembersService;

public class FirstPageController {
	
	private MembersService memServ = new MembersService();
	private Scanner scan = new Scanner(System.in);
	
	public void firstMenu() {
		
String choice = "";
		
		menuLoop:
			while(!choice.equalsIgnoreCase("0")) {
				
				System.out.println("What would you like to do? "
						+ "Please select from the options below. "
						+ "\n 1. Login."
						+ "\n 2. Create an Account."
						+ "\n 0. Exit");
				
				choice = scan.nextLine();
				switchChoice:
					switch(choice) {
					case "1":
						login();
						break switchChoice;
					case "2":
						createMember();
						break switchChoice;
					case "0":
						break switchChoice;
					default:
						System.out.println("Sorry that is not a valid input. Please select again.");
						break switchChoice;
							
					}
			}
	}

	private void createMember() {
		System.out.println("Great! Thank you for becoming a Member. \nPlease fill out the required information."+
				"\nWhat is your First Name?");
				
				MembersInfo member = new MembersInfo();
				member.setFirstName(scan.nextLine());
				
				System.out.println("What is your Last Name?");
				
				member.setLastName(scan.nextLine());
				
				System.out.println("What is your Email Address?");
				member.seteMail(scan.nextLine());
				
				System.out.println("What is your username?");
				member.setUserName(scan.nextLine());
				
				System.out.println("what is your password?");
				member.setpWord(scan.nextLine());
				
				System.out.println("Are you an Administrator?");
				String answer = scan.nextLine();
				if (answer.equalsIgnoreCase("yes")) {
					member.setAdministrator(true);
				}else {
					member.setAdministrator(false);
				}
				System.out.println("Are you a Moderator?");
				String answer2 = scan.nextLine();
				if (answer2.equalsIgnoreCase("yes")) {
					member.setModerator(true);
				}else {
					member.setModerator(false);
				}
				System.out.println("Are you a Regular Member?");
				String answer3 = scan.nextLine();
				if (answer3.equalsIgnoreCase("yes")) {
					member.setRegMember(true);
				}else {
					member.setRegMember(false);
				}
				
				memServ.newMember(member);
		
	}

	private void login() {
		String answer ="";
		System.out.println("Please enter your username.");
		answer = scan.nextLine();
		String answer2 = "";
		System.out.println("Please enter your passowrd");
		answer2 =scan.nextLine();
		if(memServ.getMemberByUser(answer, answer2)) {
			MessageMenuController mmc = new MessageMenuController();
			
			mmc.messageMenu();
		}
		

	}
}
