package userinterface

import application.service.Exchange
import domain.model._
import infrastructure.repository.CurrencyRateRepository

object Main {

  def main(args: Array[String]) {

    val exchange = new Exchange(new CurrencyRateRepository)
    (
      for {
        amount <- amount.run
        currencyFrom <- currencyFrom.run
        currencyTo <- currencyTo.run
        exchangeFrom = ExchangeFrom.apply(amount, currencyFrom)
        exchangeTime = ExchangeTime.now
        exchangeTo <- exchange.apply(exchangeFrom, CurrencyTo(currencyTo), exchangeTime)
      } yield exchangeTo
    ) match {
      case Left(t) => println(s"Input error, ${t.getMessage}")
      case Right(to) => println(s"The money after exchanged is:")
        println(s"${to.money.currency.toString} ${to.money.amount.toBigDecimal}")
    }
  }

  private def amount = for {
      _ <- IO.printLine("1. Please input money amount:")
      readAmount <- IO.readLine
      amount <- IO(AmountAdapter.apply(readAmount))
    } yield amount

  private def currencyFrom = for {
    _ <- IO.printLine("2. Please input money currency:")
    readCurrencyFrom <- IO.readLine
    currencyFrom <- IO(CurrencyAdapter.apply(readCurrencyFrom))
  } yield currencyFrom

  private def currencyTo = for {
    _ <- IO.printLine("3. Please input the currency code you want to exchange for:")
    readCurrencyTo <- IO.readLine
    currencyTo <- IO(CurrencyAdapter.apply(readCurrencyTo))
  } yield currencyTo
}
