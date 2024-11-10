object ClosureMultiplier {

  private def createMultiplier(factor: Int): Int => Int = {
   //function that closure over the factor variable
    (x: Int) => x * factor
  }

  def main(args: Array[String]): Unit = {
    val multiplyBy2 = createMultiplier(2)
    val multiplyBy3 = createMultiplier(3)
    val multiplyBy5 = createMultiplier(5)

    println(multiplyBy2(5))
    println(multiplyBy2(10))
    println(multiplyBy3(5))
    println(multiplyBy3(10))
    println(multiplyBy5(5))
    println(multiplyBy5(10))
  }
}
