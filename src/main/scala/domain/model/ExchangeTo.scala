package domain.model

case class ExchangeTo(money: Money) {

  def amount = money.amount
}

object ExchangeTo {

  def apply(amount: Amount, currencyTo: CurrencyTo): ExchangeTo =
    ExchangeTo(Money(amount, currencyTo.currency))
}
