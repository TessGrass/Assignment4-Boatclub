package assignment4.boatclub;

// import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a register in the Boat Club.
 */
public class BoatClubRegister {
  ArrayList<Member> listOfMembers = new ArrayList<>();  

  public BoatClubRegister() {

  }

  public void addMember(String theName, String theEmail) {
    System.out.print("----addMember Register-----");
    Member member = new Member(theName, theEmail, "fdgdfg");
    

    listOfMembers.add(member);
    for (Member m : listOfMembers) {
      System.out.println(m);
    }

    for (Member a : listOfMembers) {
      System.out.println(a.getName());
    }

    int idLength = 4;
    String number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder(idLength);
    for (int i = 0; i < idLength; i++) {
      sb.append(number.charAt(rnd.nextInt(number.length())));
      System.out.println(sb.toString());
    }

  /* private HashMap<String, String> memberRegister;
  
  public BoatClubRegister() {
    this.memberRegister = new HashMap<String, String>();
  }

  public void addMember(String addMember, String addMemberId) {
    this.memberRegister.put(addMemberId, addMember);
  }

  public boolean listMember() {
    System.out.println(memberRegister);
   return true; */
    /* for(Map.Entry<String, String> entry: memberRegister.entrySet()) {
    System.out.print(entry.getKey());
    System.out.print(entry.getValue());
    } 
    }*/
  }
}

