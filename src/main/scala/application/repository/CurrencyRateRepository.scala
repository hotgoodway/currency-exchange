package application.repository

import domain.model._

trait CurrencyRateRepository {

  def getBy(currencyFrom: CurrencyFrom, currencyTo: CurrencyTo, exchangeTime: ExchangeTime): Either[Throwable, ExchangeRate]
}
