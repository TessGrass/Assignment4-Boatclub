package assignment4.boatclub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    System.out.println("----addMember-----");
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
    System.out.println("----list all members----");
    if (listOfMembers.size() < 1) {
      return null;
    }
    for (Member a : listOfMembers) {
      System.out.println("NAME: " + a.getName() + " EMAIL: " + a.getEmail() + " MEMBER-ID: " + a.getMemberId()); 
    }
    return "---You have reached the end of the list----";
  }

  /**
   * List a specific member.
   *
   * @param id - The id for a member.
   * @return Returns member if found, else return No Member Found.
   */
  /* public String listSpecificMember(String id) {
    System.out.println("----listSpecificMember-----"); 
    Boolean bool = validator.runMemberIdValidator(listOfMembers, id);
    if (bool == true) { 
      for (Member a : listOfMembers) {
        if (id.equals(a.getMemberId())) {
          return "NAME: " + a.getName() + " EMAIL: " + a.getEmail() 
            + " MEMBER-ID: " + a.getMemberId() + " BOAT: " + a.getBoat() + "\n";
        }
      }
    }
    return null;
  } */

  /**
   * Delete a member.
   */
  public Boolean deleteMember(String id) {
    System.out.println("----deleteMember-----");
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
    System.out.println("----addBoat-----");
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
    System.out.println("----List Member boat-----");
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
    System.out.println("----Delete member boat-----");
    for (Member a : listOfMembers) {
      if (id.equalsIgnoreCase(a.getMemberId())) {
        a.deleteBoat(name);
        return "The Boat was successfully deleted";
      }
    }
    return null;
  }

  public void writeToFile() {
    // String projectPath = ("/src/main/java/assignment4/registry/registry.data");
    // String relativeToAbsolute = new File("").getAbsolutePath();
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + url));
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

  public void readFromFile() {
    String projectPath = ("/src/main/java/assignment4/registry/registry.data");
    String relativeToAbsolute = new File("").getAbsolutePath();
    String[] parts = null;
    int theHorsepower = 0;
    int theDepth = 0;
    String id = null;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath + url));
      String line;
       if (reader.readLine() != null)  
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
         /*  if ("Boat".equalsIgnoreCase(parts[0])) {
            System.out.print("här");
            System.out.print(parts[1]);
            // do something
        } */
    }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

// 0=Boat, 1=namn 2=typ 3=längd 4=Horsepower 5=depth
/* for(String element: parts) {
  if(element == "Member") {
    
  }
} */
/* for(int i = 0; i < parts.length(); i++) {    */

        // System.out.println(Arrays.toString(parts));
       /*      for (String element: parts) { */

            /* System.out.println(); */
         /*  System.out.println(element);
          str.add(element); */
      /* } */
     /*  for(int i = 0; i < str.size(); i++) {   
        Member member = new Member(str[1], str[2], str[3]);
        listOfMembers.add(member);
    }   */
      /* for (String i = 0;  < parts.length; i++) {
        Member member = new Member(parts[1], parts[1], parts[1]);
      }
       */
        // System.out.print(parts[1]);
        /* Member member = new Member(parts[1], parts[1], parts[1]);
        listOfMembers.add(member); */
        /* for (String element: parts) {
          System.out.print
          System.out.println(element);
      } */
      // Member member = new Member(parts[0], parts[1], parts[2]);
       //System.out.print(parts[0]);
       //System.out.print(parts[1]);
       /* System.out.print(parts[2]);
       System.out.print(parts[3]); */
        /* Member member = new Member(parts[0], parts[1], parts[2]);
        listOfMembers.add(member); */

