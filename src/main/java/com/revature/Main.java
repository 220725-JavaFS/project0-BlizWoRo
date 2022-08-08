package com.revature;

import com.revature.controllers.FirstPageController;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to New Tech Messaging. How may I be of service?");
		
		FirstPageController fpc = new FirstPageController();
		
		fpc.firstMenu();
		
//		MessageMenuController mmc = new MessageMenuController();
//		
//		mmc.messageMenu();
		
		System.out.println("Thank you for using New Tech Messaging. Good Bye.");

	}

}
