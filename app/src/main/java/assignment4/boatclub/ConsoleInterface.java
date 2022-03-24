package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents the main application of a boat club.
 */
public class ConsoleInterface {
  /* private BoatClubRegister register = new BoatClubRegister();
  private BoatFactory boatFactory = new BoatFactory();
  private Scanner scan = new Scanner(System.in); */

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
                      + "2. List all members / Edit a specific member\n"
                      + "3. Exit the application");

  
    System.out.print("\nChoose a number: ");
      /* int input = scan.nextInt();
      scan.nextLine(); */

     /*  if (input == 1) {
        addMember();
      } else if (input == 2) {
        listMembers();
      } else if (input == 3) {
        exitProgram();
      } else {
        System.out.println("\n ! Please enter a valid number from the menu ! \n");
      } */

  }

  // FROM METHOD ADDMEMBER //

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
    System.out.print("\nA) Get more info about a member\nB) Add boat to member\nC) Delete member\nD) Return to menu\n"
         + "Choose A, B, C or D to continue: ");
  }
  
  public void enterMemberId() {
    System.out.print("Enter a members id: ");
  }

  public void askForInputInMemberMenu() {
    System.out.print("A) Get details of a specific boat\n" + "B) Quit to menu\n" + "Choose A or B to continue: ");
  }

  public void deleteMember() {
    System.out.println("The member is deleted\n");
  }

  /**
   * ask for the Boat type.
   */
  public void askForBoatType() {
    System.out.println("We accept the following type of boats: \n" + "A) Motorboat \n"
          + "B) MotorSailer \n" + "C) Sailboat \n" + "D) Canoe");
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

  public void closeProgram() {
    System.out.print("Program terminated");
  }

  public void errorMessage() {
    System.out.println("\nSomething went wrong. Returning to menu.");
  }



 
  

  /**
   * Add a member to the Boat Club.
   */
  /* public void addMember() {
    try {
      Boolean bool = true;
      System.out.print("Add a name: ");
      String name = scan.nextLine();
      while (bool) {
        System.out.print("Add an email (Enter to skip): ");
        String email = scan.nextLine();
        bool = register.addMember(name, email);
        if (bool) {
          System.out.println("Email already taken, please try again");
        }
      }
      System.out.println("The member was successfully created!");
      consoleUi();
    } catch (Exception e) {
      System.out.println("Something went wrong");
      exitProgram();
    }
  } */

  /**
   * List of all members.
   */
  /* public void listMembers() {
    try {
      String input = register.listAllMembers();
      if (input == null) {
        System.out.println("\nNo members currently available");
        consoleUi();
      }
      System.out.print("\nA) Get more info about a member\nB) Add boat to member\nC) Delete member\nD) Return to menu\n"
          + "Choose A, B, C or D to continue: ");
      input = scan.nextLine();
      if (input.equalsIgnoreCase("D")) {
        consoleUi();
      }
      System.out.print("Enter a members id: ");
      String id = scan.nextLine();
      if (input.equalsIgnoreCase("A")) {
        System.out.println(register.listSpecificMember(id));          
        System.out.print("A) Get details of a specific boat\n" + "B) Quit to menu\n" + "Choose A or B to continue: ");
        input = scan.nextLine();
        if (input.equalsIgnoreCase("A")) {
          listMembersAllBoats(id);
        } else {
          consoleUi();
        }
      } else if (input.equalsIgnoreCase("B")) {
        addBoatToMember(id);
      } else if (input.equalsIgnoreCase("C")) {
        register.deleteMember(id);
        System.out.println("The member is deleted\n");
      } else if (input.equalsIgnoreCase("D")) {
        consoleUi();
      }
  
      consoleUi();
      
    } catch (Exception e) {
      System.out.println("Something went wrong.");
      exitProgram();
    }    
  } */

  /**
   * Adding a boat to a member.
   *
   * @param memberId - The members id.
   */
 /*  public void addBoatToMember(String memberId) {
    String id = memberId;
    String boatType = null;
    String boatName = null;
    int boatLength = 0;
    int boatPower = 0;
    int boatDepth = 0;
    try {
      System.out.println("We accept the following type of boats: \n" + "A) Motorboat \n"
          + "B) MotorSailer \n" + "C) Sailboat \n" + "D) Canoe");
      System.out.print("Enter A, B, C, or D to add: ");
      boatType = scan.nextLine();
      System.out.print("Enter the name of boat you want to add: ");
      boatName = scan.nextLine();
      System.out.print("Enter the length of the boat in meters: ");
      boatLength = scan.nextInt();
      if (boatType.equalsIgnoreCase("A")) {
        System.out.print("Enter number of horsepower in Integer (Enter 0 to skip): ");
        boatPower = scan.nextInt();
      } else if (boatType.equalsIgnoreCase("B")) {
        System.out.print("Enter number of horsepower in Integer (Enter 0 to skip): ");
        boatPower = scan.nextInt();
        System.out.print("Enter the boat's depth in meter (Enter 0 to skip): ");
        boatDepth = scan.nextInt();
      } else if (boatType.equalsIgnoreCase("C")) {
        System.out.print("Enter the boat's depth in meter (Enter 0 to skip): ");
        boatDepth = scan.nextInt();
      }
      
      Boat memberBoat = boatFactory.makeBoat(boatType, boatName, boatLength, boatPower, boatDepth);
      register.addBoat(memberBoat, id);
      System.out.println("\nBoat successfully added to member!");
      consoleUi();


    } catch (Exception e) {
      System.out.println("Something went wrong");
      exitProgram();
    }
  } */

  /**
   * List members all boat.
   *
   * @param id - the members id.
   */
  /* public void listMembersAllBoats(String id) {
    try {
      String input = null;  
      Boolean bool = register.listMemberBoat(id);
      if (!bool) {
        System.out.print("\nNo boats where found. Returning to menu\n");
        consoleUi();
      }
      System.out.print("\nA) Delete a boat\n" + "B) Quit to menu\nChoose A or B to continue: ");
      input = scan.nextLine();
      if (input.equalsIgnoreCase("A")) {
        System.out.print("Enter the name of the boat you want to delete: ");
        input = scan.nextLine();
        deleteBoat(input, id);
      } else {
        consoleUi();
      }
    } catch (Exception e) {
      System.out.println("Something went wrong");
      exitProgram();
    }
  } */

  /**
   * Deletes a boat.
   *
   * @param boat - the boat.
   * @param id - the id.
   */
  /* public void deleteBoat(String boat, String id) {
    System.out.println("---deletemethod main----");
    register.deleteMemberBoat(boat, id);
  }

  public void exitProgram() {
    System.out.print("Program terminated");
    System.exit(0);
  } */
}
