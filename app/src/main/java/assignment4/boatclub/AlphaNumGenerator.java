package assignment4.boatclub;

import java.lang.StringBuilder;
import java.util.Random;

/**
 * Represents a Alpha Numeric Generator.
 */
public class AlphaNumGenerator {
  Random rnd = new Random();
  
  /**
   * Alpha Numeric Generator.
   */
  public String alphaNumGen() {
    int idLength = 4;
    String memberId = null;
    String number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder(idLength);
    for (int i = 0; i < idLength; i++) {
      sb.append(number.charAt(rnd.nextInt(number.length())));
      memberId = sb.toString();
    }
    return memberId;
  }
}
