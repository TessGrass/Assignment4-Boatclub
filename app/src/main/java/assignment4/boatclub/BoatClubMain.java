package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents a Boat Club class.
 */
public class BoatClubMain {
  private ConsoleInterface console = new ConsoleInterface();
  private BoatClubRegister register = new BoatClubRegister();
  private BoatFactory boatFactory = new BoatFactory();
  private Scanner scan = new Scanner(System.in);

  /**
     * Main method of the program.
     *
     * @param args - Potential argument.
     */
  public static void main(String[] args) {
    BoatClubMain boatClub = new BoatClubMain(); 
    boatClub.inputFromMenu();  
  }
  
    
  /**
   * Start menu.
   */
  public void inputFromMenu() {
    System.out.println("Inputfrommenu");
    console.consoleUi();
    int input = scan.nextInt();
    scan.nextLine();

    while (true) {
      if (input == 1) {
        addMember();
      } else if (input == 2) {
        listMembers();
      } else if (input == 3) {
        exitProgram();
      } else {
        System.out.println("\n ! Please enter a valid number from the menu ! \n");
      }
    }
  }

  /**
   * Add a member to the Boat Club.
   */
  public void addMember() {
    try {
      Boolean bool = true;
      console.askForMemberName();
      String name = scan.nextLine();
      console.askForMemberEmail();
      String email = scan.nextLine();
      while (bool) {
        bool = register.addMember(name, email);
        if (bool) {
          console.emailTakenTrue();
          console.askForMemberEmail();
        }
      }
      console.createMemberDone();
      inputFromMenu();
    } catch (Exception e) {
      console.errorMessage();
      exitProgram();
    }
  }

  /**
   * List of all members.
   */
  public void listMembers() {
    try {
      String input = register.listAllMembers();
      if (input == null) {
        console.noMembersAvailable();
        inputFromMenu();
      }
      console.askForInputInListMenu();
      input = scan.nextLine();
      if (input.equalsIgnoreCase("D")) {
        inputFromMenu();
      }
      console.enterMemberId();
      String id = scan.nextLine();
      if (input.equalsIgnoreCase("A")) {
        System.out.println(register.listSpecificMember(id));
        console.askForInputInMemberMenu();
        input = scan.nextLine();
        if (input.equalsIgnoreCase("A")) {
          listMembersAllBoats(id);
        } else {
          inputFromMenu();
        }
      } else if (input.equalsIgnoreCase("B")) {
        addBoatToMember(id);
      } else if (input.equalsIgnoreCase("C")) {
        register.deleteMember(id);
        console.deleteMember();
      } else if (input.equalsIgnoreCase("D")) {
        inputFromMenu();
      }
      inputFromMenu();
    } catch (Exception e) {
      System.out.println("Something went wrong. Returning to menu.");
      inputFromMenu();
    }
  }

  /**
   * Adding a boat to a member.
   *
   * @param id - The members id.
   */
  public void addBoatToMember(String id) {
    try {
      int boatPower = 0;
      int boatDepth = 0;
      System.out.println("addboattomember");
      console.askForBoatType();
      String boatType = scan.nextLine(); 
      console.askForBoatName();
      String boatName = scan.nextLine();
      console.askForBoatLength();
      int boatLength = scan.nextInt();
      if (boatType.equalsIgnoreCase("A")) {
        console.askForHorsePower();
        boatPower = scan.nextInt();
      } else if (boatType.equalsIgnoreCase("B")) {
        console.askForHorsePower();
        boatPower = scan.nextInt();
        console.askForBoatDepth();
        boatDepth = scan.nextInt();
      } else if (boatType.equalsIgnoreCase("C")) {
        console.askForBoatDepth();
        boatDepth = scan.nextInt();
      }
      Boat memberBoat = boatFactory.makeBoat(boatType, boatName, boatLength, boatPower, boatDepth);
      register.addBoat(memberBoat, id);
      console.boatAddedToMember();
      inputFromMenu();
    } catch (Exception e) {
      System.out.println("Something went wrong. Returning to menu.");
      inputFromMenu();
    } 
  }
  
  /**
   * List members all boat.
   *
   * @param id - the members id.
   */
  public void listMembersAllBoats(String id) {
    try {
      System.out.println("listmembersboat");
      Boolean bool = register.listMemberBoat(id);
      if (!bool) {
        console.noBoatsWasFound();
        inputFromMenu();
      }
      console.askForInputFromBoatMenu();
      String input = scan.nextLine();
      deleteBoat(input, id);
    } catch (Exception e) {
      System.out.println("Something went wrong. Returning to menu.");
      inputFromMenu();
    }
  }

  /**
   * Deletes a boat.
   *
   * @param boat - the boat.
   * @param id - the id.
   */
  public void deleteBoat(String boat, String id) {
    System.out.println("---deletemethod main----");
    register.deleteMemberBoat(boat, id);
  }

  public void exitProgram() {
    console.closeProgram();
    System.exit(0);
  }
}
 