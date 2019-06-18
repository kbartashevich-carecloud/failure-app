package forex;

import java.util.Locale;

public class CurrencyValidator {
  public enum Currency {USD, GPB, EUR}

  public static class UnsupportedCurrencyException
    extends Exception {
    public UnsupportedCurrencyException(String raw) {
      super("Currency must be USD/EUR/GBP, not " + raw);
    }
  }

  public static Currency validateCurrency(String raw)
    throws UnsupportedCurrencyException {

    String rawUpper = raw.toUpperCase(Locale.ENGLISH);
    try {
      return Currency.valueOf(rawUpper);
    } catch (IllegalArgumentException iae) {
      throw new UnsupportedCurrencyException(raw);
    }
  }
}