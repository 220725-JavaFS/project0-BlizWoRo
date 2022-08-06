package com.revature;

import com.revature.controllers.MessageMenuController;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to New Tech Messaging. How may I be of service?");
		
		MessageMenuController mmc = new MessageMenuController();
		
		mmc.messageMenu();
		
		System.out.println("Thank you for using New Tech Messaging. Good Bye.");

	}

}
