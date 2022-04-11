package assignment4.boatclub;

import java.util.ArrayList;

/**
 *  Represents a id Validator class.
 */
public class MemberInfoValidator {

  /**
   * Checks if memberId is unique.
   *
   * @param listOfMembers - ArrayList of current members.
   * @param id - The member id.
   * @return boolean.
   */
  public Boolean runMemberIdValidator(ArrayList<Member> listOfMembers, String id) {
    Boolean bool = false;
    for (Member a : listOfMembers) {
      if (id.equals(a.getMemberId())) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   * Checks for email duplicate in the system.
   *
   * @param listOfMembers - All the current members.
   * @param theEmail - the email that is going to get validated.
   * @return a boolean.
   */
  public Boolean runMemberEmailValidator(ArrayList<Member> listOfMembers, String theEmail) {
    Boolean bool = false;
    if (theEmail.equals("N/A")) {
      return bool;
    }
    for (Member a : listOfMembers) {
      if (theEmail.equals(a.getEmail())) {
        bool = true;
      } else {
        continue;
      }
    }
    return bool;
  } 
}
