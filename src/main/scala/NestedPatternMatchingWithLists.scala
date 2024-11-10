case class Product(name: String, price: Double)
case class Order(id: Int, products: List[Product], discountCode: Option[String])

def matchOrder(order: Order): String = order match
  case Order(id, products, Some(discount)) if products.nonEmpty =>
    val total = products.map(_.price).sum
    val discountedTotal = total * 0.9 // 10% discount
    val productNames = products.map(_.name).mkString(", ")
    s"Order #$id contains the following products: $productNames. Total cost with discount: ${discountedTotal}."
  case Order(id, products, None) if products.nonEmpty =>
    val total = products.map(_.price).sum
    val productNames = products.map(_.name).mkString(", ")
    s"Order #$id contains the following products: $productNames. Total cost: ${total}."
  case Order(id, Nil, _) =>
    s"Order #$id contains no products."

object NestedPatternMatchingExample:
  def main(args: Array[String]): Unit =
    // Creating instances of orders
    val order1 = Order(1, List(Product("Laptop", 1200.0), Product("Mouse", 25.0)), Some("DISCOUNT10"))
    val order2 = Order(2, List(Product("Monitor", 300.0)), None)
    val order3 = Order(3, Nil, Some("EMPTYORDER"))


    println(matchOrder(order1)) // Prints details of the order with a discount
    println(matchOrder(order2)) // Prints details of the order without a discount
    println(matchOrder(order3)) // Prints that the order contains no products