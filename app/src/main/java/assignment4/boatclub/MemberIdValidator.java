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
    System.out.println("----runValidator-----");
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
}
