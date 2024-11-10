object HigherOrderFunctionExample {

  // Higher-order function that accepts a predicate and returns a new function
  def createFilter(predicate: Int => Boolean): List[Int] => List[Int] = {
    // Returns a new function that filters a list based on the given predicate
    (list: List[Int]) => list.filter(predicate)
  }

  // Predicate --- show with will happen if remove type parameter
  val isEven: Int => Boolean = _ % 2 == 0

  // Function that filters even numbers
  val filterEvens = createFilter(isEven)


  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = filterEvens(numbers)
    println(evenNumbers)
  }
}