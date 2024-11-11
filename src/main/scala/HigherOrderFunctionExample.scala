object HigherOrderFunctionExample {

  // Higher-order function that accepts a predicate and returns a new function
  def createFilter(predicate: Int => Boolean): List[Int] => List[Int] = {
    // Returns a new function that filters a list based on the given predicate
    (list: List[Int]) => list.filter(predicate)
  }

  // Predicate to check if a number is even
  val isEven: Int => Boolean = _ % 2 == 0

  // Predicate to check if a number is divisible by 3
  val isDivisibleBy3: Int => Boolean = _ % 3 == 0

  // Function that filters even numbers
  private val filterEvens: List[Int] => List[Int] = createFilter(isEven)

  private val filterDivisibleBy3 = createFilter(isDivisibleBy3)

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = filterEvens(numbers)
    val every3Numbers = filterDivisibleBy3(numbers)
    println(evenNumbers)
    println(every3Numbers)
  }
}