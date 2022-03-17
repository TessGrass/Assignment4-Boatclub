package assignment4.boatclub;

/**
 * Represents a Boat Factory.
 */
public class BoatFactory {

  /**
   * Represents a Boat Factory.
   *
   * @param newBoatType 
   * @return
   */
  public Boat makeBoat(String newBoatType) {
  
    if (newBoatType == null) {
      return null;
    }

    if (newBoatType.equalsIgnoreCase("Motorboat")) {
      return new Motorboat();
    } else if (newBoatType.equals("Motorsailer")) {
      return new Motorsailer();
    } else if (newBoatType.equals("Sailboat")) {
      return new Canoe();
    } else if (newBoatType.equals("Canoe")) {
      return new Canoe();
    }
    return null;
  }
}
