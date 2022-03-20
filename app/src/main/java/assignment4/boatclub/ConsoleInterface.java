package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents the main application of a boat club.
 */
public class ConsoleInterface {
  private BoatClubRegister members = new BoatClubRegister();
  private BoatFactory boatFactory = new BoatFactory();
  private Scanner scan = new Scanner(System.in);

  /**
   * The consoleUi of the Boat Club.
   */
  public void consoleUi() {
    while (true) {
      System.out.println();
      System.out.println("----------------------------------------\n"
                      + "| WELCOME TO THIS EXCLUSIVE BOAT CLUB! |\n"
                      + "----------------------------------------\n"
                      + "Please make your choice from the consoleUi below:\n"
                      + "1. Add a new member to the boat club\n"
                      + "2. List all members / Edit a specific member\n"
                      + "3. Add a boat to member\n"
                      + "4. Read info about a specific boat\n"
                      + "5. Exit the application");

  
      System.out.print("\nChoose a number: ");
      int input = scan.nextInt();
      scan.nextLine();
                
      switch (input) {
        case 1:
          addMember();
          break;
        case 2:
          listMembers();
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        default:
          System.out.println("\n ! Please enter a valid number from the consoleUi ! \n");
          break;
      }
    }
  }

  /**
   * Add a member to the Boat Club.
   */
  public void addMember() {
    try {
      System.out.print("Add a name: ");
      String name = scan.nextLine();
      System.out.print("Add an email (Optional): ");
      String email = scan.nextLine();
      if (email.length() < 1) {
        email = "N/A";
      }
      Boolean bool = members.addMember(name, email);
      while (bool) {
        System.out.println("Email already taken, please try again");
        System.out.print("Add an email (Enter to skip): ");
        email = scan.nextLine();
        bool = members.addMember(name, email);
      }
      System.out.print("The member was successfully created!\nPress Enter to return to consoleUi:");
      System.in.read();
    } catch (Exception e) {
      System.out.println("Something went wrong");  // CLOSE THE PROGRAM GRACEFULLY
    }
  }

  /**
   * List of all members.
   */
  public void listMembers() {
    try {
      members.listAllMembers();
      System.out.print("Do you want to get info / add boat to a specific member? Y/N: "); {
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("y")) {
          System.out.print("Enter a members id: ");
          String id = scan.nextLine();
          // members.listSpecificMember(id);
          System.out.print("Do you want to add a boat? Y/N: ");
          String addBoat = scan.nextLine();
          if (addBoat.equalsIgnoreCase("y")) {
            addBoatToMember(id);
          }
          System.out.print("Do you want to delete the member Y/N: ");
          String deleteMember = scan.nextLine();
          if (deleteMember.equalsIgnoreCase("y")) {
            members.deleteMember(id);
            System.out.println("The member is deleted\n");
          }
        }
      }
      System.out.print("Press Enter to return to Menu");
      System.in.read();
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }    
  }

  /**
   * Adding a boat to a member.
   *
   * @param memberId - The members id.
   */
  public void addBoatToMember(String memberId) {
    try {
      String id = memberId;
      System.out.print(id);  
      System.out.print(members.listAllMembers());
      System.out.println("We accept the following type of boats: \n" + "A) Motorboat \n"
          + "B) Sailboat \n" + "C) Motorsailer \n" + "D) Canoe");
      System.out.print("Enter A, B, C, or D to add: ");
      String boatType = scan.nextLine();
      System.out.print("Enter the name of boat you want to add: ");
      String boatName = scan.nextLine();
      System.out.print("Enter the length of the boat (Enter 0 to skip): ");
      int boatLength = scan.nextInt();
      System.out.print("Enter number of horsepower (Enter 0 to skip): ");
      int boatPower = scan.nextInt();
      System.out.print("Enter the boats depth (Enter 0 to skip): ");
      int boatDepth = scan.nextInt();
      System.out.print(boatLength + boatDepth + boatPower);
      Boat memberBoat = boatFactory.makeBoat(boatType, boatName, boatLength, boatPower, boatDepth);
      members.addBoat(memberBoat, id);
      System.out.println(memberBoat);
      System.out.println("Press Enter to return to Menu");
      System.in.read(); 


    } catch (Exception e) {
      System.out.println("Something went wrong");  // CLOSE THE PROGRAM GRACEFULLY
    }
  }
}
