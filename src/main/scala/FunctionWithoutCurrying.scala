object FunctionWithoutCurrying {


  def createPricingCalculator(basePrice: Double, discount: Double, tax: Double, quantity: Int): Double = {
    val discountedPrice = basePrice - (basePrice * discount / 100)
    val totalPrice = discountedPrice + (discountedPrice * tax / 100)
    totalPrice * quantity
  }

  def main(args: Array[String]): Unit = {
   
    val totalPrice = createPricingCalculator(50.0, 10.0, 5.0, 2)
    println(totalPrice)
  }
}
