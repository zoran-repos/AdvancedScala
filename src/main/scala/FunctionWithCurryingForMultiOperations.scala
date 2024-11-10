
def createPricingCalculator(basePrice: Double)(discount: Double)(tax: Double)(quantity: Int): Double = {
  val discountedPrice = basePrice - (basePrice * discount / 100)
  val totalPrice = discountedPrice + (discountedPrice * tax / 100)
  totalPrice * quantity
}

//use hint from IDE to add type annotation to the function
val priceCalculator = createPricingCalculator(50.0)
val discount10Calculator = priceCalculator(10.0)


object FunctionWithCurryingForMultiOperations {
  def main(args: Array[String]): Unit = {
    println(discount10Calculator(5.0)(2))
  }
}