package assignment4.boatclub;

/**
 * Represents a Member class.
 */
public abstract class Member {
  private String name;
  private String memberId;
  private String email;

  public Member() {

  }

  /**
   * Constructor for the Member class.
   *
   * @param name - The name of the member.
   * @param memberId - The member's id.
   * @param email - The members email (optional).
   */
  public Member(String name, String memberId, String email) {
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
  
}