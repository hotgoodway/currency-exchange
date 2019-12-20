package userinterface

import domain.model.Amount

import scala.util.{Failure, Success, Try}

object AmountAdapter {

  def apply(string: String): Either[Throwable, Amount] = Try {
    BigDecimal.apply(string)
  } match {
    case Success(value) if value > 0 => Right(Amount(value))
    case Failure(_) => Left(new Throwable(s"Invalid value: ${string}"))
  }
}
