@main def mainChainTransformations(): Unit = {
  def filterEvens(numbers: List[Int]): List[Int] = {
    numbers.filter(_ % 2 == 0)
  }

  def doubleNumbers(numbers: List[Int]): List[Int] = {
    numbers.map(_ * 2)
  }

  def sumNumbers(numbers: List[Int]): Int = {
    numbers.sum
  }

  // Combining all stages
  val numbers = List(1, 2, 3, 4, 5, 6)
  val result = sumNumbers(doubleNumbers(filterEvens(numbers)))
  println(result)
}