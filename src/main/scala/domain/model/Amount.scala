package domain.model

case class Amount(private val underlying: BigDecimal) {

  def *(rate: Rate): Amount = Amount(underlying * rate.toBigDecimal)

  def toBigDecimal = underlying
}
