package userinterface

import domain.model.Currency
import domain.model.Currency.{JPY, USD}

object CurrencyAdapter {

  def apply(string: String): Either[Throwable, Currency] =
    string.toUpperCase() match {
      case "JPY" => Right(JPY)
      case "USD" => Right(USD)
      case _ => Left(new Throwable(s"Not supported currency code: ${string}" ))
    }
}
