package domain.model

case class ExchangeFrom(money: Money) {

  lazy val currency = CurrencyFrom(money.currency)

  def * (rate: Rate, currencyTo: CurrencyTo): ExchangeTo = ExchangeTo(money.amount * rate, currencyTo)
}

object ExchangeFrom {

  def apply(amount: Amount, currency: Currency): ExchangeFrom =
    ExchangeFrom(Money(amount, currency))
}
