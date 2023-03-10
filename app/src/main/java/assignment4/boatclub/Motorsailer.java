package assignment4.boatclub;

/**
 * Represents a Motorsailor class.
 */
public class Motorsailer extends Boat {
  private int depth;
  private int horsepower;
  private String boatType = "Motorsailer";

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

  public String getBoatType() {
    return boatType;
  }

  @Override
  public String getBoatDetails() {
    return "TYPE: " + getBoatType() + " NAME: " + getName() + " LENGTH " +  getLength() + " meters " 
        + " HORSEPOWER: " + getHorsepower() + "hk" + " DEPTH: " + getDepth() + " ";
  }

  @Override
  public String detailsToString() {
    return "\nBOAT:" + getName() + ":" + getBoatType() + ":" + getLength() + ":" + getDepth() + ":" + getHorsepower();
  }
}
