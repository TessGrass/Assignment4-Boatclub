package assignment4.boatclub;

/**
 * Represents the main application of a boat club.
 */
public class ConsoleInterface {

  /**
   * The consoleUi of the Boat Club.
   */
  public void consoleUi() {
    System.out.println();
    System.out.println("----------------------------------------\n"
                      + "| WELCOME TO THIS EXCLUSIVE BOAT CLUB! |\n"
                      + "----------------------------------------\n"
                      + "Please make your choice from the menu below:\n"
                      + "1. Add a new member to the boat club\n"
                      + "2. List all members / List member's boats / Add boat\n"
                      + "3. Exit the application");  
    System.out.print("\nChoose a number: ");
  }

  public void askForMemberName() {
    System.out.print("Add a name: ");
  }

  public void askForMemberEmail() {
    System.out.print("Add an email (Enter to skip): ");
  }

  public void emailTakenTrue() {
    System.out.println("Email already taken, please try again");
  }

  public void createMemberDone() {
    System.out.println("\nThe member was successfully created!");
  }

  public void noMembersAvailable() {
    System.out.println("\nNo members currently available");
  }

  public void askForInputInListMenu() {
    System.out.print("A) List a member's boats\nB) Add boat to member\nC) Delete member\nD) Return to menu\n"
         + "Choose A, B, C or D to continue: ");
  }
  
  public void enterMemberId() {
    System.out.print("Enter a members id: ");
  }

  /* public void askForInputInMemberMenu() {
    System.out.print("A) Get details of the boats\n" + "B) Quit to menu\n" + "Choose A or B to continue: ");
  }
 */
  public void deleteMember() {
    System.out.println("\nThe member is deleted");
  }

  public void askForBoatType() {
    System.out.println("We accept the following type of boats: \n" + "A) Motorboat \n"
          + "B) MotorSailer \n" + "C) Sailboat \n" + "D) Canoe");
  }

  public void askForBoatTypeInput() {
    System.out.print("Enter A, B, C, or D to add: ");
  }

  public void askForBoatName() {
    System.out.print("Enter the name of boat you want to add: ");
  }

  public void askForBoatLength() {
    System.out.print("Enter the length of the boat in meters: ");
  }
  
  public void askForHorsePower() {
    System.out.print("Enter number of horsepower in Integer: ");    
  }

  public void askForBoatDepth() {
    System.out.print("Enter the boat's depth in meter: ");    
  }

  public void boatAddedToMember() {
    System.out.println("\nBoat successfully added to member!");    
  }

  public void noBoatsWasFound() {
    System.out.print("\nNo boats was found. Returning to menu");    
  }

  public void askForInputFromBoatMenu() {
    System.out.print("\nA) Delete a boat\n" + "B) Quit to menu\nChoose A or B to continue: ");    
  }

  public void askForBoatNameDelete() {
    System.out.print("Enter the name of boat you want to delete: ");
  }

  public void closeProgram() {
    System.out.print("\nProgram closed");
  }

  public void errorMessage() {
    System.out.println("\nSomething went wrong. Returning to menu.");
  }

  public void wrongInput() {
    System.out.println("\nWrong input. Try again.\n");
  }

  public void errorWrongInputStartMenu() {
    System.out.println("\n ! Please enter a valid number from the menu !");
  }
}
