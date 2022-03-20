package assignment4.boatclub;

/**
 * Represent a Boat superclass.
 */
public abstract class Boat {
  private String name;
  private int length;

  public Boat() {

  }

  
  public Boat(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return this.name;
  }

  /**
   * Sets the name of the Boat.
   *
   * @param theName - the name.
   */
  public void setName(String theName) {
    if (theName != null && theName.length() > 0) {
      this.name = theName;
    } else {
      System.out.println("The name of the boat must contain characters");
    }
  }

  public int getLength() {
    return this.length;
  }

  /**
   * Sets the length of the boat.
   *
   * @param theLength - the length of the boat.
   */
  public void setLength(int theLength) {
    if (theLength > 1) {
      this.length = theLength;
    } else {
      System.out.println("The boat must be longer than 1 meter.");
    }
  }

  public abstract String getBoatDetails();
}
