package application.service

import application.repository.CurrencyRateRepository
import domain.model._

class Exchange(currencyRateRepository: CurrencyRateRepository) {

  def apply(exchangeFrom: ExchangeFrom, currencyTo: CurrencyTo, exchangeTime: ExchangeTime): Either[Throwable, ExchangeTo] =
    for {
      currencyRate <- currencyRateRepository.getBy(exchangeFrom.currency, currencyTo, exchangeTime)
      exchangeTo = exchangeFrom * (currencyRate.rate, currencyRate.currencyTo)
    } yield exchangeTo

}

