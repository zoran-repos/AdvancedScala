trait Adder[T] {
  def add(x: T, y: T): T
}

implicit object IntAdder extends Adder[Int] {
  def add(x: Int, y: Int): Int = x + y
}

implicit object DoubleAdder extends Adder[Double] {
  def add(x: Double, y: Double): Double = x + y
}

// Custom complex number type
case class ComplexNumber(real: Double, imaginary: Double)

// Implicit instance for ComplexNumber
implicit object ComplexNumberAdder extends Adder[ComplexNumber] {
  def add(x: ComplexNumber, y: ComplexNumber): ComplexNumber = {
    ComplexNumber(x.real + y.real, x.imaginary + y.imaginary)
  }
}

def addValues[T](x: T, y: T)(implicit adder: Adder[T]): T = {
  adder.add(x, y)
}

object AdderWithTypeClass {
  def main(args: Array[String]): Unit = {
    val intResult = addValues(3, 5)
    val doubleResult = addValues(2.5, 3.5)
    val complexResult = addValues(ComplexNumber(1.0, 2.0), ComplexNumber(3.0, 4.0))

    println(s"Int result: $intResult")
    println(s"Double result: $doubleResult")
    println(s"Complex result: ${complexResult.real} + ${complexResult.imaginary}i")
  }
}