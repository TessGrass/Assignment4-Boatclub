package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents the main application of a boat club.
 */
public class ConsoleUI {
  BoatClubRegister members = new BoatClubRegister();
  Scanner scan = new Scanner(System.in);

  /**
   * The menu of the Boat Club.
   */
  public void menu() {
    while (true) {
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
          addMember();
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

  public void addMember() {
    String name;
    String email;
    System.out.print("Add a name: ");
    name = scan.nextLine();
    System.out.print("Add a email(Leave blank if not provided): ");
    email = scan.nextLine();
    if (email == null) {
      email = "-";
    }
    members.addMember(name, email);
  }
}
