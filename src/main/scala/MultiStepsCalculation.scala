@main def mainMultiStepsCalculation(): Unit = {
  def add(x: Double, y: Double): Double = x + y
  def multiply(x: Double, y: Double): Double = x * y
  def square(x: Double): Double = x * x

  def calculateExpression(a: Double, b: Double, c: Double): (Double, Double, Double) = {
    val step1 = add(a, b)
    val step2 = multiply(step1, c)
    val result = square(step2)
    (step1, step2, result)
  }

  val (step1, step2, result) = calculateExpression(2, 3, 4)
  println(s"Step 1 (add): $step1")
  println(s"Step 2 (multiply): $step2")
  println(s"Result (square): $result")
  println(result)
}