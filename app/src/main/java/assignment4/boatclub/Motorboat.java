package assignment4.boatclub;

/**
 * Represents a Motorboat class.
 */
public class Motorboat extends Boat {
  private int horsepower;
  private String boatType = "Motorboat";

  public Motorboat() {

  }

  public Motorboat(String name, int length, int horsepower) {
    super(name, length);
    this.horsepower = horsepower;
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
    return "TYPE: " + getBoatType() + " NAME: " + getName() 
      + " LENGTH " +  getLength() + " meters" + " HORSEPOWER: " + getHorsepower() + "hk ";
  }

  @Override
  public String fileToString() {
    return "\nBOAT: " + getName() + ":" + getBoatType() + ":" + getLength() + ":" + getHorsepower();
  }
}
