package assignment4.boatclub;

/**
 * Represents a Canoe class.
 */
public class Canoe extends Boat {
  private String boatType = "Canoe";
  
  public Canoe() {
  }

  public Canoe(String name, int length) {
    super(name, length);
  }

  public String getBoatType() {
    return boatType;
  }

  @Override
  public String getBoatDetails() {
    return "TYPE: " + boatType + " NAME: " + getName() + " LENGTH " +  getLength() + " meters";
  }

  @Override
  public String fileToString() {
    return "\nBOAT: " + getName() + ":" + getBoatType() + ":" + getLength();
  }
}
