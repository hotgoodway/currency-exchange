package domain.model

case class Rate(private val underlying: BigDecimal) {

  def toBigDecimal = underlying
}
