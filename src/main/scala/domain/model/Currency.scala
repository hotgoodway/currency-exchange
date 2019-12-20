package domain.model

sealed trait Currency

object Currency {

  case object JPY extends Currency
  case object USD extends Currency
}

