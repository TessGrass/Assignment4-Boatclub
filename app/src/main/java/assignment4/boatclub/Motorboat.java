package assignment4.boatclub;

/**
 * Represents a Motorboat class.
 */
public class Motorboat extends Boat {
  private int horsepower;  

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

  @Override
  public String getBoatDetails() {
    if (this.horsepower == 0) {
      return "NAME: " + getName() + " LENGTH " +  getLength() + " meters";
    }
    return "NAME: " + getName() + " LENGTH " +  getLength() + " HORSEPOWER: " + getHorsepower() + "hk";
  }
}
