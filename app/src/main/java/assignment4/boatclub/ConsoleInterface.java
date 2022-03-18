package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents the main application of a boat club.
 */
public class ConsoleInterface {
  BoatClubRegister members = new BoatClubRegister();
  private Scanner scan = new Scanner(System.in);

  /**
   * The menu of the Boat Club.
   */
  public void menu() {
    while (true) {
      System.out.println();
      System.out.println("----------------------------------------\n"
                      + "| WELCOME TO THIS EXCLUSIVE BOAT CLUB! |\n"
                      + "----------------------------------------\n"
                      + "Please make your choice from the menu below:\n"
                      + "1. Add a new member to the boat club\n"
                      + "2. List all members / Specific member\n"
                      + "3. Delete member\n"
                      + "4. Add a boat to member\n"
                      + "5. Read info about a specific boat\n"
                      + "6. Exit the application");

  
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
          System.out.println("\n ! Please enter a valid number from the menu ! \n");
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
      Boolean b = members.addMember(name, email);
      while (b) {
        System.out.println("Email already taken, please try again");
        System.out.print("Add an email (Optional): ");
        email = scan.nextLine();
        b = members.addMember(name, email);
      }
      System.out.print("The member was succesfully created! Press Enter to return to menu: ");
      System.in.read();
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
}

  /**
   * List of all members.
   */
  public void listMembers() {
    try {
      members.listAllMembers();
      /* if (members.listAllMembers() == null) {
        System.out.print("No members to display. ");
      } else { */
      System.out.print("Do you want to see/delete a specific member y/n: "); {
        String input;
        input = scan.nextLine();
        if (input.equalsIgnoreCase("y")) {
          System.out.print("Enter a members id: ");
          String id = scan.nextLine();
          String member = members.listSpecificMember(id);
          System.out.println(member);
          System.out.print("Do you want to delete member y/n: ");
          input = scan.nextLine();
          if (input.equalsIgnoreCase("y")) {
            members.deleteMember(id);
            System.out.println("Member is deleted\n");
          }
        }
        // }
      }
      System.out.print("Press Enter to return to Menu");
      System.in.read();
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }    
  }
}
