package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.LevelMember;
import com.revature.models.MembersInfo;
import com.revature.models.Message;
import com.revature.services.LevelService;
import com.revature.services.MembersService;
import com.revature.services.MessageServices;

public class AdminMenu {
	
	private MessageServices messServ = new MessageServices();
	private MembersService memServ = new MembersService();
	private LevelService level = new LevelService();
	private Scanner scan = new Scanner(System.in);
	
	public void adminMenu() {
		
		String choice = "";
		
		menuLoop:
			while(!choice.equalsIgnoreCase("0")) {
				
				System.out.println("What would you like to do? "
						+ "Please select from the options below. "
						+ "\n 1. View All messages."
						+ "\n 2. Update member information."
						+ "\n 3. Send a new message."
						+ "\n 4. Count your total messages."
						+ "\n 5. Count total members."
						+ "\n 6. Delete a member."
						+ "\n 7. View Current Members."
						+ "\n 8. Update member level."
						+ "\n 0. LogOut");
				
				choice = scan.nextLine();
				switchChoice:
					switch(choice) {
					case "1":
						seeReceivedMessage();
						break switchChoice;
					case "2":
						seeUpdateMember();
						break switchChoice;
					case "3":
						createMessage();
						break switchChoice;
					case "4":
						countTotalMessage();
						break switchChoice;
					case "5":
						countTotalMember();
						break switchChoice;
					case "6":
						deleteMember();
						break switchChoice;
					case "7":
						viewMember();
						break switchChoice;
					case "8":
						updateLevel();
						break switchChoice;
					case "0":
						break switchChoice;
					default:
						System.out.println("Sorry that is not a valid input. Please select again.");
						break switchChoice;
							
					}
			}
		
	}

	public void updateLevel() {
		String answer ="";
		String eMail = "";
		String adminAnswer = "";
		String modAnswer = "";
		String regAnswer = "";
		boolean admin = false;
		boolean moder = false;
		boolean reg = false;
		while(!answer.equalsIgnoreCase("exit")) {
			System.out.println("Who would you like to update the level of?"
					+ "\nType the email address to change the level."
					+ "\nType 'EXIT' to exit.");
			
			answer = scan.nextLine();
			if(answer.equalsIgnoreCase("exit")) {
				return;
			}else {
				
				eMail=answer;
				System.out.println("Will the member be an administrator?");
				adminAnswer = scan.nextLine();
				System.out.println("Will the member be a moderator?");
				modAnswer = scan.nextLine();
				System.out.println("Will the member be a regular member?");
				regAnswer = scan.nextLine();
				
				if (adminAnswer.equalsIgnoreCase("yes")&&modAnswer.equalsIgnoreCase("no")&&regAnswer.equalsIgnoreCase("no")) {
					admin = true;
					moder = false;
					reg = false;
				}
				else if (adminAnswer.equalsIgnoreCase("no")&&modAnswer.equalsIgnoreCase("yes")&&regAnswer.equalsIgnoreCase("no")) {
					admin = false;
					moder = true;
					reg = false;
				}
				else if (adminAnswer.equalsIgnoreCase("no")&&modAnswer.equalsIgnoreCase("no")&&regAnswer.equalsIgnoreCase("yes")) {
					admin = false;
					moder = false;
					reg = true;
				}else {
					System.out.println("Only choose 1 status level to say 'YES' in.");
				}
//			
				
				try {
					eMail = answer;
				}catch(Exception e) {
					System.out.println("Not valid Input. Try Again.");
					continue;
				}
				LevelMember levelmem = level.getMemberLevel(eMail, admin, moder, reg); 
			}
		}
		return;
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

	public void seeUpdateMember() {
			String answer ="";
			while(!answer.equalsIgnoreCase("exit")) {
				System.out.println("What would you like to do? "
						+ "\nType 'All' to view all members, column names, and their ID's."
						+ "\nTo update a particular member, type 'ID' for the ID. "
						+ "\nType 'EXIT' to exit and go back to previous menu.");
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
					String change = "";
					String columnName = "";
					System.out.println("What would you like to update?");
					columnName=scan.nextLine();
					if(columnName.equalsIgnoreCase("firstname")) {
						
						System.out.println("What would you like to change it to?");
						change=scan.nextLine();
						try {
							id=Integer.parseInt(answer);
						}catch(NumberFormatException e) {
							System.out.println("Not a valid input. Please try again.");
							continue;
						}
						MembersInfo member = memServ.getUpdateMemberFirst(id, change);
					}else if(columnName.equalsIgnoreCase("lastname")) {
						
						System.out.println("What would you like to change it to?");
						change=scan.nextLine();
						try {
							id=Integer.parseInt(answer);
						}catch(NumberFormatException e) {
							System.out.println("Not a valid input. Please try again.");
							continue;
						}
						MembersInfo member = memServ.getUpdateMemberLast(id, change);
					
					}else if(columnName.equalsIgnoreCase("eMail")) {
						
						System.out.println("What would you like to change it to?");
						change=scan.nextLine();
						try {
							id=Integer.parseInt(answer);
						}catch(NumberFormatException e) {
							System.out.println("Not a valid input. Please try again.");
							continue;
						}
						MembersInfo member = memServ.getUpdateMembereMail(id, change);
					}else if(columnName.equalsIgnoreCase("username")) {
						
						System.out.println("What would you like to change it to?");
						change=scan.nextLine();
						try {
							id=Integer.parseInt(answer);
						}catch(NumberFormatException e) {
							System.out.println("Not a valid input. Please try again.");
							continue;
						}
						MembersInfo member = memServ.getUpdateMemberUser(id, change);
					}else if(columnName.equalsIgnoreCase("password")) {
						
						System.out.println("What would you like to change it to?");
						change=scan.nextLine();
						try {
							id=Integer.parseInt(answer);
						}catch(NumberFormatException e) {
							System.out.println("Not a valid input. Please try again.");
							continue;
						}
						MembersInfo member = memServ.getUpdateMemberPass(id, change);
					}
					
				}
			}
			
		}


	private void deleteMember() {
		String answer ="";
		while(!answer.equalsIgnoreCase("exit")) {
			System.out.println("Which member would you like to delete."
					+ "\nPlease type 'ID' to give the ID number of the soon to be deleted member."
					+ "\nType 'EXIT' to exit.");
			answer = scan.nextLine();
			
			if(answer.equalsIgnoreCase("exit")) {
				return;
			}else {
				int id = 0;
				
				try {
					id= Integer.parseInt(answer);
				}catch(NumberFormatException e) {
					System.out.println("No Member Found. Please try again.");
					continue;
				}
				
				MembersInfo member = memServ.getDeleteMember(id);
				
				System.out.println("The member has been deleted.");
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
									totalAdmin();
									break switchChoice;
								case "2":
									totalMod();
									break switchChoice;
								case "3":
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

	private void totalAdmin() {
		String answer = "";
		while(!answer.equalsIgnoreCase("exit")) {
			System.out.println("Would you like to see the total administrator count?"
					+ "\nIf yes type'YES' and if no type 'EXIT'.");
			answer=scan.nextLine();
			
			if(answer.equalsIgnoreCase("yes")) {
				
				MembersInfo adminCount = memServ.getMembersAdminCount(0, null);
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
							+ "for all received messages. "
							+ "\nTYPE 'EXIT' to exit.");
			answer = scan.nextLine();
			//String eMail = "dH@sight.com";
			if (answer.equalsIgnoreCase("all")) {
				List<Message> list = messServ.allMessage();
				System.out.println("Here are all the messages: ");
				int count =0;
				for(Message a:list){
					count++;
					System.out.println(a);// get all messages
				}
				System.out.println("Total Messages: " +count);
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
				int count = 0;
				//messServ.
				System.out.println("Here is your message: \n" + message);
				
			}

		}
		
	}

}
