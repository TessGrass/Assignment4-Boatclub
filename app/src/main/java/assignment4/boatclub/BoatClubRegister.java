package assignment4.boatclub;

import java.util.ArrayList;

/**
 * Represents a register in the Boat Club.
 */
public class BoatClubRegister {
  ArrayList<Member> listOfMembers = new ArrayList<>();
  AlphaNumGenerator alphaNum = new AlphaNumGenerator();
  MemberIdValidator validator = new MemberIdValidator();


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
    /* for (Member a : listOfMembers) {
      System.out.println("NAME: " + a.getName() + " EMAIL: " + a.getEmail() + " ID: " + a.getMemberId());
    } */
    return false;
  }

  /**
   * Lists all members.
   *
   * @return a list with all members.
   */
  public String listAllMembers() {
    String member = null;
    if (listOfMembers.size() < 1) {
      return null;
    }
    for (Member a : listOfMembers) {
      System.out.println("NAME: " + a.getName() + " EMAIL: " + a.getEmail() + " ID: " + a.getMemberId());
    }
    return member;
  }

  /**
   * List a specific member.
   *
   * @param id - The id for a member.
   * @return Returns member if found, else return No Member Found.
   */
  public String listSpecificMember(String id) {
    System.out.println("----listSpecificMember-----"); 
    Boolean b = validator.runMemberIdValidator(listOfMembers, id);
    if (b == true) { 
      for (Member a : listOfMembers) {
        if (id.equals(a.getMemberId())) {
          return "NAME: " + a.getName() + " EMAIL: " + a.getEmail() + " ID: " + a.getMemberId() + "\n";
        }
      }
    }
    return "No Member Found";
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

  public void addBoat() {
    
  }



  /* public boolean runValidator(String name) {
    System.out.println("----runValidator-----");
    Boolean b = false;
    for (Member a : listOfMembers) {
      System.out.println("for each");
      System.out.println(name);
      System.out.println(a.getName());
      if (name.equals(a.getName())) {
        System.out.println("if true");
        b = true;
      } else {
        System.out.println("continue");
        continue;
      }
    }
    return b;
  } */
}

