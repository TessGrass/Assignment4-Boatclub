package assignment4.boatclub;

/**
 * Represents a Sailboat class.
 */
public class Sailboat extends Boat {
  private int depth;

  public Sailboat() {

  }

  public Sailboat(String name, int length, int depth) {
    super(name, length);
  }

  public int getDepth() {
    return depth;
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
  public void getInfo() {
    // TODO Auto-generated method stub
    
  }
  
}
