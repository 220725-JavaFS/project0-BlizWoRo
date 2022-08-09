package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.LevelMember;
import com.revature.models.MembersInfo;
import com.revature.services.LevelService;
import com.revature.services.MembersService;

public class FirstPageController {
	
	private LevelService levelmem = new LevelService();
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
				LevelMember level = new LevelMember();
				MembersInfo member = new MembersInfo();
				String email = "";
				member.setFirstName(scan.nextLine());
				
				System.out.println("What is your Last Name?");
				
				member.setLastName(scan.nextLine());
				
				System.out.println("What is your Email Address?");
				email = scan.nextLine();
				member.seteMail(email);
				level.seteMail(email);
				
				System.out.println("What is your username?");
				member.setUserName(scan.nextLine());
				
				System.out.println("what is your password?");
				member.setpWord(scan.nextLine());
				
				
				
				memServ.newMember(member, level);
		
	}

	private void login() {
		String answer ="";
		System.out.println("Please enter your username.");
		answer = scan.nextLine();
		String answer2 = "";
		System.out.println("Please enter your password");
		answer2 =scan.nextLine();
		if(memServ.getMemberByUserAdmin(answer, answer2)==true) {
			AdminMenu am = new AdminMenu();
			
			am.adminMenu();
		}else if(memServ.getMemberByUserMod(answer, answer2)==true) {
			ModMenu mm = new ModMenu();
			mm.modMenu();
		}else if(memServ.getMemberByUserReg(answer, answer2)==true) {
			RegMenu rm = new RegMenu();
			
			rm.regMenu();
		}else {
		System.out.println("not a valid user. Please try again.");
			
			return;
		}
	}
}
