package assignment4.boatclub;

import java.util.Scanner;

/**
 * Represents a Boat Club class.
 */
public class BoatClubMain {
  private ConsoleInterface console = new ConsoleInterface();
  private BoatClubRegister register = new BoatClubRegister();
  private BoatFactory boatFactory = new BoatFactory();
  private Scanner scan = new Scanner(System.in, "UTF-8");

  /**
     * Main method of the program.
     *
     * @param args - Potential argument.
     */
  public static void main(String[] args) {
    BoatClubMain boatClub = new BoatClubMain();
    boatClub.init(); 
    boatClub.inputFromMenu();  
  }  
    
  /**
   * Start menu.
   */
  public void inputFromMenu() {
    
    try {

      console.consoleUi();
      String input = scan.nextLine();
      if (input.equals("1")) {
        addMember();
      } else if (input.equals("2")) {
        listMembers();
      } else if (input.equals("3")) {
        register.writeToFile();
        exitProgram();
      } else {
        console.errorWrongInputStartMenu();
        inputFromMenu();
      }
    } catch (Exception e) {
      console.errorMessage();
      inputFromMenu();
    }
  }

  /**
   * Add a member to the Boat Club.
   */
  public void addMember() {
    try {
      console.askForMemberName();
      String name = scan.nextLine();
      if (name.length() < 1) {
        addMember();
      }
      console.askForMemberEmail();
      String email = scan.nextLine();
      Boolean bool = true;
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
      String inputFromUser = scan.nextLine();
      input = inputFromUser.toLowerCase();
      validateInput(input);
      if (input.equalsIgnoreCase("D")) {
        inputFromMenu();
      }
      console.enterMemberId();
      String id = scan.nextLine();
      if (input.equalsIgnoreCase("A")) {
        listMembersAllBoats(id);
      } else if (input.equalsIgnoreCase("B")) {
        addBoatToMember(id);
      } else if (input.equalsIgnoreCase("C")) {
        register.deleteMember(id);
        console.deleteMember();
        inputFromMenu();
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
      String boatType = null;
      boatType = scan.nextLine();
      validateInput(boatType);
      console.askForBoatName();
      String boatName = null;
      boatName = scan.nextLine();
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
      scan.nextLine();
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
      Boolean bool = register.listMemberBoat(id);
      if (!bool) {
        console.noBoatsWasFound();
        inputFromMenu();
      }
      console.askForInputFromBoatMenu();
      String input = scan.nextLine();
      if (input.equalsIgnoreCase("a")) {
        console.askForBoatNameDelete();
        String name = scan.nextLine();
        deleteBoat(name, id);
      }
    } catch (Exception e) {
      console.errorMessage();
      inputFromMenu();
    }
  }

  /**
   * Validate input from menu.
   *
   * @param in the input.
   * @return input
   */
  public String validateInput(String in) {
    String input = in;
    Boolean bool = true;
    while (bool) {
      if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) {
        return input;
      } else {
        console.errorMessage();
        inputFromMenu();
      }
    }
    return input;
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
      } else {
        console.wrongInput();
        console.askForHorsePower();
        boatPower = scan.nextInt();
      }
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
      } else {
        console.wrongInput();
        console.askForBoatDepth();
        boatDepth = scan.nextInt();
      }
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
      } else {
        console.wrongInput();
        console.askForBoatLength();
        boatLength = scan.nextInt();
      }
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
    register.deleteMemberBoat(boat, id);
  }

  private void init() {
    register.readFromFile();
  }

  /**
   * Exits the program.
   */
  public void exitProgram() {
    scan.close();
    console.closeProgram();
    System.exit(0);
  }
}
 