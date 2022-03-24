package assignment4.boatclub;

/**
 * Represents a Sailboat class.
 */
public class Sailboat extends Boat {
  private int depth;
  private String boatType = "Sailboat";

  public Sailboat() {

  }

  public Sailboat(String name, int length, int depth) {
    super(name, length);
  }

  public int getDepth() {
    return depth;
  }

  public String getBoatType() {
    return boatType;
  }

  /**
   * Sets the depth of the sailboat.
   *
   * @param theDepth - the depth.
   */
  public void setDepth(int theDepth) {
    if (theDepth > 0) {
      this.depth = theDepth;
    } else {
      System.out.println("The depth of the boat must be deeper than zero meters.");
    }
  }

  @Override
  public String getBoatDetails() {
    return "TYPE: " + getBoatType() + " NAME: " + getName() + " LENGTH " +  getLength() + " DEPTH: " + getDepth() + " ";
  }

  @Override
  public String fileToString() {
    return "\nBOAT: " + getName() + ":" + getBoatType() + ":" + getLength() + ":" + getDepth();
   
  }
}
