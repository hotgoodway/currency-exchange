package domain.model

case class ExchangeRate(currencyFrom: CurrencyFrom, currencyTo: CurrencyTo, rate: Rate, exchangeTime: ExchangeTime)
