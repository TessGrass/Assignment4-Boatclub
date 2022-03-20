package assignment4.boatclub;

/**
 * Represents a Boat Factory.
 */
public class BoatFactory {

  public BoatFactory() {

  }

  /**
   * Represents a Boat Factory.
   *
   * @param newBoatType - The boat type that want's to be created.
   * @return Boat type or null.
   */
  public Boat makeBoat(String newBoatType, String theName, int theLength, int theHorsepower, int theDepth) {
  
    if (newBoatType == null) {
      return null;
    }

    if (newBoatType.equalsIgnoreCase("Motorboat")) {
      return new Motorboat(theName, theLength, theHorsepower);
    } else if (newBoatType.equalsIgnoreCase("Motorsailer")) {
      return new Motorsailer(theName, theLength, theHorsepower, theDepth);
    } else if (newBoatType.equalsIgnoreCase("Sailboat")) {
      return new Sailboat(theName, theLength, theDepth);
    } else if (newBoatType.equalsIgnoreCase("Canoe")) {
      return new Canoe(theName, theLength);
    }
    return null;
  }
}
