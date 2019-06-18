package forex

object Currency extends Enumeration {
  type Currency = Value
  val Usd = Value("USD")
  val Gbp = Value("GBP")
  val Eur = Value("EUR")
}

case class UnsupportedCurrencyException(raw: String)
  extends Exception("Currency must be USD/EUR/GBP, not " + raw)

object CurrencyValidator1 {

  @throws(classOf[UnsupportedCurrencyException])
  def validateCurrency(raw: String): Currency.Value = {

    val rawUpper = raw.toUpperCase(java.util.Locale.ENGLISH)
    try {
      Currency.withName(rawUpper)
    } catch {
      case nsee: NoSuchElementException =>
        throw new UnsupportedCurrencyException(raw)
    }
  }
}