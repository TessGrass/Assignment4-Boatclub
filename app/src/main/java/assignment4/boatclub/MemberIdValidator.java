package assignment4.boatclub;

import java.util.ArrayList;

/**
 *  Represents a id Validator class.
 */
public class MemberIdValidator {

  /**
   * Checks if memberId is unique.
   *
   * @param listOfMembers - ArrayList of current members.
   * @param id - The member id.
   * @return boolean.
   */
  public Boolean runMemberIdValidator(ArrayList<Member> listOfMembers, String id) {
    System.out.println("----runIdValidator-----");
    Boolean b = false;
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        b = true;
      } else {
        continue;
      }
    }
    return b;
  }

  public Boolean runMemberEmailValidator(ArrayList<Member> listOfMembers, String theEmail) {
    System.out.println("----runEmailValidator-----");
    Boolean b = false;
    if (theEmail.equals("N/A")) {
      return b;
    }
    for (Member a : listOfMembers) {
      if (theEmail.equals(a.getEmail())) {
        b = true;
      } else {
        continue;
      }
    }
    return b;
  } 
}
