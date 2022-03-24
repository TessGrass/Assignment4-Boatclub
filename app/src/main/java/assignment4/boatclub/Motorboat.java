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

  public String getBoatType() {
    return boatType;
  }

  public void setHorsepower(int theHorsepower) {
    this.horsepower = theHorsepower;
  }

  @Override
  public String getBoatDetails() {
    return "TYPE: " + boatType + " NAME: " + getName() 
      + " LENGTH " +  getLength() + " meters" + " HORSEPOWER: " + getHorsepower() + "hk ";
  }
}
