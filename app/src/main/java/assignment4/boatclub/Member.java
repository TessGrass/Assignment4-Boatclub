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

  /**
   * Gets member email.
   *
   * @return email if available, else empty string.
   */
  public String getEmail() {
    if (this.email.equalsIgnoreCase("N/A")) {
      return "";
    }
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the name of the members boat.
   *
   * @return The name of the boat.
   */
  public String getBoat() {
    for (Boat a : memberBoat) {
      return a.getName();

    }
    return "-";
  }

  public void setBoat(Boat boat) {
    memberBoat.add(boat);
  }

  /**
   * Get boat details.
   */
  public void getBoatDetails() {
    for (Boat a : memberBoat) {
      System.out.println(a.getBoatDetails());
    }
  }
  
  /**
   * Delete's a members boat.
   *
   * @param boat - The boat.
   * @return boolean.
   */
  public Boolean deleteBoat(String boat) {
    Boolean bool = false;
    for (Boat a : memberBoat) {
      System.out.print(boat);
      if (boat.equalsIgnoreCase(a.getName())) {
        System.out.print(a);
        memberBoat.remove(a);
        return true;
      }
    }
    return bool;
  }

  public String boatToString() {
    String line = "";
    for (Boat b : memberBoat) {
      line += b.detailsToString();
    }
    return line;
  }

  public String memberToString() {
    return "\nMEMBER:" + getName() + ":" + getEmail() + ":" + getMemberId();
  }
}
