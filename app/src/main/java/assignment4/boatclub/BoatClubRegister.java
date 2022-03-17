package assignment4.boatclub;

import java.util.HashMap;

/**
 * Represents a register in the Boat Club.
 */
public class BoatClubRegister {
  private HashMap<String, String> memberRegister;
  
  public BoatClubRegister() {
    this.memberRegister = new HashMap<String, String>();
  }

  public void addMember(String addMember, String addMemberId) {
    this.memberRegister.put(addMemberId, addMember);
    System.out.println(this.memberRegister);
  }


}

