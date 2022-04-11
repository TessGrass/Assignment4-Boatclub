package assignment4.boatclub;

import java.lang.StringBuilder;
import java.util.Random;

/**
 * Represents a Alpha Numeric Generator.
 */
public class AlphaNumGenerator {
  private Random rnd;

  public AlphaNumGenerator() {
    this.rnd = new Random();
  }
  
  /**
   * Alpha Numeric Generator.
   */
  public String alphaNumGen() {
    System.out.println("-----AlphaNumGen-----");
    int idLength = 6;
    String memberId = null;
    String number = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder(idLength);
    for (int i = 0; i < idLength; i++) {
      sb.append(number.charAt(rnd.nextInt(number.length())));
      memberId = sb.toString();
    }
    return memberId;
  }
}
