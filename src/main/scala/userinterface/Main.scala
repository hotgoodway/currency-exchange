package userinterface

import application.service.Exchange
import domain.model._
import infrastructure.repository.CurrencyRateRepository

import scala.io.StdIn

object Main {

  def main(args: Array[String]) {

    println("1. Please input money amount:")
    val amount = AmountAdapter.apply(StdIn.readLine())

    println("2. Please input money currency:")
    val currency = CurrencyAdapter.apply(StdIn.readLine())

    println("3. Please input the currency code you want to exchange for:")
    val currencyTo = CurrencyAdapter.apply(StdIn.readLine()).map(CurrencyTo(_))

    val exchange = new Exchange(new CurrencyRateRepository)
    (
      for {
        amount <- amount
        currency <- currency
        currencyTo <- currencyTo
        exchangeTime = ExchangeTime.now
        exchangeTo <- exchange.apply(ExchangeFrom.apply(amount, currency), currencyTo, exchangeTime)
      } yield exchangeTo
    ) match {
      case Left(t) => println(s"Input error, ${t.getMessage}")
      case Right(to) => println(s"The money after exchanged is:")
        println(s"${to.money.currency.toString} ${to.money.amount.toBigDecimal}")
    }
  }
}
