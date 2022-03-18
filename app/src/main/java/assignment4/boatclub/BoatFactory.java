package assignment4.boatclub;

/**
 * Represents a Boat Factory.
 */
public class BoatFactory {

  /**
   * Represents a Boat Factory.
   *
   * @param newBoatType - The boat type that want's to be created.
   * @return Boat type.
   */
  public Boat makeBoat(String newBoatType) {
  
    if (newBoatType == null) {
      return null;
    }

    if (newBoatType.equalsIgnoreCase("Motorboat")) {
      return new Motorboat();
    } else if (newBoatType.equalsIgnoreCase("Motorsailer")) {
      return new Motorsailer();
    } else if (newBoatType.equalsIgnoreCase("Sailboat")) {
      return new Canoe();
    } else if (newBoatType.equalsIgnoreCase("Canoe")) {
      return new Canoe();
    }
    return null;
  }
}
