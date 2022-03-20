package assignment4.boatclub;

import java.util.ArrayList;

/**
 * Represents a register in the Boat Club.
 */
public class BoatClubRegister {
  ArrayList<Member> listOfMembers = new ArrayList<>();
  AlphaNumGenerator alphaNum = new AlphaNumGenerator();
  MemberInfoValidator validator = new MemberInfoValidator();


  public BoatClubRegister() {

  }

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
      return "No members was found";
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
  public String listSpecificMember(String id) {
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
  }

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
  public void addBoat(Boat type, String id) {
    System.out.println("----addBoat-----");
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        a.setBoat(type);
      }
    }
  }

  /**
   * List member boat.
   *
   * @param id - the member id.
   * @return - Boat details.
   */
  public String listMemberBoat(String id) {
    System.out.println("----List Member boat-----");
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        a.getBoatDetails();
      }
    }
    return "No boat was found";
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
        System.out.println("if-satsen delete");
        a.deleteBoat(name);
        return "The Boat was successfully deleted";
      }
    }
    return "No boat was found";
  }
}

