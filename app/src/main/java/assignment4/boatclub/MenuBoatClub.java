package assignment4.boatclub;

// import java.util.Scanner;

/**
 * Represents the main application of a boat club.
 */
public class MenuBoatClub {
  BoatClubRegister members = new BoatClubRegister();

  /**
   * the menu of the Boat Club.
   */
  public void menu() {
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


  }

  

  /* public void memberRegister(String n, String b) {
    members.addMember(n, b);
  } */
}
