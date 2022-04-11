package assignment4.boatclub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;



/**
 * Represents a register in the Boat Club.
 */
public class BoatClubRegister {
  ArrayList<Member> listOfMembers = new ArrayList<>();
  AlphaNumGenerator alphaNum = new AlphaNumGenerator();
  MemberInfoValidator validator = new MemberInfoValidator();
  private BoatFactory boatFactory = new BoatFactory();
  private String url = "/src/main/java/assignment4/registry/registry.data";
  private String filePath = new File("").getAbsolutePath();



  /**
   * Add a member to the Boat Club.
   *
   * @param theName - The name.
   * @param theEmail - The email.
   */
  public Boolean addMember(String theName, String theEmail) {
    if (theEmail.length() < 1) {
      theEmail = "N/A";
    }
    Boolean email = validator.runMemberEmailValidator(listOfMembers, theEmail);
    if (email == true) {
      return true;
    }
    String memberId = alphaNum.alphaNumGen();
    Boolean id = validator.runMemberIdValidator(listOfMembers, memberId);    
    if (id == true) {
      memberId = alphaNum.alphaNumGen();
    }  
    Member member = new Member(theName, theEmail, memberId);
    listOfMembers.add(member);
    return false;
  }

  /**
   * Lists all members.
   *
   * @return a list with all members.
   */
  public String listAllMembers() {
    if (listOfMembers.size() < 1) {
      return null;
    }
    for (Member a : listOfMembers) {
      System.out.println("NAME: " + a.getName() + " EMAIL: " + a.getEmail() + " MEMBER-ID: " + a.getMemberId()); 
    }
    return "---You have reached the end of the list----";
  }

  /**
   * Delete a member.
   */
  public Boolean deleteMember(String id) {
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        listOfMembers.remove(a);
        return true;
      }
    }
    return false;
  }

  /**
   * Adds a boat to a member.
   *
   * @param type - the type of boat.
   * @param id - the members id.
   */
  public String addBoat(Boat type, String id) {
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        a.setBoat(type);
      }
    }
    return "Boat added!";
  }

  /**
   * List member boat.
   *
   * @param id - the member id.
   * @return - Boat details.
   */
  public Boolean listMemberBoat(String id) {
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId()) && a.getBoat() != "-") {
        a.getBoatDetails();
        return true;
      }
    }
    return false;
  }

  /**
   * Delete a members boat.
   *
   * @param id - the name of the boat.
   * @return message.
   */
  public String deleteMemberBoat(String name, String id) {
    for (Member a : listOfMembers) {
      if (id.equalsIgnoreCase(a.getMemberId())) {
        a.deleteBoat(name);
        return "The Boat was successfully deleted";
      }
    }
    return null;
  }

  /**
   * writeToFile.
   */
  public void writeToFile() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + url, StandardCharsets.UTF_8));
      for (Member a : listOfMembers) {
        writer.write(a.memberToString());
        writer.write(a.boatToString());
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (Member a : listOfMembers) {
      System.out.print(a.memberToString());
      System.out.print(a.boatToString());
    }   
  }

  /**
   * Read from file.
   */
  public void readFromFile() {
    String[] parts = null;
    int theHorsepower = 0;
    int theDepth = 0;
    String id = null;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath + url, StandardCharsets.UTF_8));
      String line;
      if (reader.readLine() != null) {
        while ((line = reader.readLine()) != null) {
          parts = line.split(":");
          if (parts[0].equalsIgnoreCase("member")) {
            id = parts[3];
            Member member = new Member(parts[1], parts[2], parts[3]);
            listOfMembers.add(member);
          } else if (parts[0].equalsIgnoreCase("boat")) {
            if (parts[2].equalsIgnoreCase("Canoe")) {
              int theLength = Integer.parseInt(parts[3]);
              String theName = parts[1];
              Boat memberBoat = boatFactory.makeBoat("D", theName, theLength, theHorsepower, theDepth);
              addBoat(memberBoat, id);              
            } else if (parts[2].equalsIgnoreCase("Motorboat")) {
              int theLength = Integer.parseInt(parts[3]);
              theHorsepower = Integer.parseInt(parts[4]);
              String theName = parts[1];
              Boat memberBoat = boatFactory.makeBoat("D", theName, theLength, theHorsepower, theDepth);
              addBoat(memberBoat, id);              
            } else if (parts[2].equalsIgnoreCase("Motorsailer")) {
              theDepth = Integer.parseInt(parts[5]);
              int theLength = Integer.parseInt(parts[3]);
              theHorsepower = Integer.parseInt(parts[4]);
              String theName = parts[1];
              Boat memberBoat = boatFactory.makeBoat("D", theName, theLength, theHorsepower, theDepth);
              addBoat(memberBoat, id);  
            }
          }
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
