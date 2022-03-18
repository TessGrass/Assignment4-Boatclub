package assignment4.boatclub;

import java.util.ArrayList;

/**
 * Represents a Member class.
 */
public class Member {
  private String name;
  private String memberId;
  private String email;
  private ArrayList<Boat> memberBoat = new ArrayList<>();

  public Member() {

  }

  /**
   * Constructor for the Member class.
   *
   * @param name - The name of the member.
   * @param memberId - The member's id.
   * @param email - The members email (optional).
   */
  public Member(String name, String email, String memberId) {
    this.name = name;
    this.memberId = memberId;
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  /**
   * Sets the members name.
   *
   * @param theName - the name of the member.
   */
  public void setName(String theName) {
    if (theName != null && theName.length() > 1) {
      this.name = theName;
    } else {
      System.out.println("The name of the member must be longer than one character.");
    }
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boat getBoat() {
    for (Boat a : memberBoat) {
      System.out.println("NAME: " + a.getName());
    }
    return null;
  }

  public void setBoat(Boat boat) {
    memberBoat.add(boat);
  }
  
}
