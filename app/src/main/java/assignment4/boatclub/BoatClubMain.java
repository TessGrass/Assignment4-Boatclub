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
      console.errorMessage();
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

      console.askForBoatType();
      console.askForBoatTypeInput();
      String boatType = scan.nextLine(); 
      console.askForBoatName();
      String boatName = scan.nextLine();
      console.askForBoatLength();
      int boatLength = scan.nextInt();
      boatLength = validateLength(boatLength);
    
      if (boatType.equalsIgnoreCase("A")) {
        console.askForHorsePower();
        boatPower = scan.nextInt();
        boatPower = validateHorsepower(boatPower);
      } else if (boatType.equalsIgnoreCase("B")) {
        console.askForHorsePower();
        boatPower = scan.nextInt();
        boatPower = validateHorsepower(boatPower);
        console.askForBoatDepth();
        boatDepth = scan.nextInt();
        boatDepth = validateDepth(boatDepth);
      } else if (boatType.equalsIgnoreCase("C")) {
        console.askForBoatDepth();
        boatDepth = scan.nextInt();
        boatDepth = validateDepth(boatDepth);
      }

      Boat memberBoat = boatFactory.makeBoat(boatType, boatName, boatLength, boatPower, boatDepth);
      register.addBoat(memberBoat, id);
      console.boatAddedToMember();
      inputFromMenu();
    } catch (Exception e) {
      console.errorMessage();
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
      console.errorMessage();
      inputFromMenu();
    }
  }

  /**
   * Validate horsepower.
   *
   * @param power - horsepower from user input.
   * @return correct horsepower.
   */
  public int validateHorsepower(int power) {
    int boatPower = power;
    Boolean bool = true;
    while (bool) {
      if (boatPower > 0 && boatPower < 11000) {
        bool = false;
        return boatPower;
      }
      console.wrongInput();
      console.askForHorsePower();
      boatPower = scan.nextInt();
    }
    return boatPower;
  }

  /**
   * Validate depth.
   *
   * @param depth - depth from user input.
   * @return correct depth.
   */
  public int validateDepth(int depth) {
    int boatDepth = depth;
    Boolean bool = true;
    while (bool) {
      if (boatDepth > 0 && boatDepth < 30) {
        bool = false;
        return boatDepth;
      }
      console.wrongInput();
      console.askForBoatDepth();
      boatDepth = scan.nextInt();
    }
    return boatDepth;
  }

  /**
   * Validate length.
   *
   * @param length - length from user input.
   * @return correct length.
   */
  public int validateLength(int length) {
    int boatLength = length;
    Boolean bool = true;
    while (bool) {
      if (boatLength > 0 && boatLength < 80) {
        bool = false;
        return boatLength;
      }
      console.wrongInput();
      console.askForBoatLength();
      boatLength = scan.nextInt();
    }
    return boatLength;
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
 