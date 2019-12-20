package domain.model

import java.time.LocalDateTime

case class ExchangeTime(private val underlying: LocalDateTime)

object ExchangeTime {

  def now = ExchangeTime(LocalDateTime.now())
}
