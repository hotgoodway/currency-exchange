package infrastructure.repository
import domain.model.Currency.{JPY, USD}
import domain.model._

class CurrencyRateRepository extends application.repository.CurrencyRateRepository {

  override def getBy(currencyFrom: CurrencyFrom, currencyTo: CurrencyTo, exchangeTime: ExchangeTime) = {
    // Demoのため固定化している
    val rate = (currencyFrom.currency, currencyTo.currency) match {
      case (JPY, JPY) => Right(Rate(1.0))
      case (USD, USD) => Right(Rate(1.0))
      case (JPY, USD) => Right(Rate(0.00909))
      case (USD, JPY) => Right(Rate(110.0))
      case _ => Left(new Throwable("Not support"))
    }
    rate.map(ExchangeRate(currencyFrom, currencyTo, _, exchangeTime))
  }
}
