package assignment4.boatclub;

/**
 * Represents a Motorsailor class.
 */
public class Motorsailer extends Boat {
  private int depth;
  private int horsepower;

  public Motorsailer() {

  }

  /**
   * The constructor of the Motorsailer class.
   *
   * @param name - The name of the motorsailer.
   * @param length - The length of the motorsailer.
   * @param depth - The depth of the motorsailer.
   * @param horsepower - The horsepower of the motorsailer.
   */
  public Motorsailer(String name, int length, int depth, int horsepower) {
    super(name, length);
    this.depth = depth;
    this.horsepower = horsepower;    
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int theDepth) {
    this.depth = theDepth;
  }

  public int getHorsepower() {
    return horsepower;
  }

  public void setHorsepower(int theHorsepower) {
    this.horsepower = theHorsepower;
  }

  @Override
  public void getInfo() {
    // TODO Auto-generated method stub
    
  }

}
