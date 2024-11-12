// Define custom traits
trait Show[T] {
  def show(value: T): String
}

trait Addable[T] {
  def add(x: T, y: T): T
}

// Function that uses both `context bounds`: `Show` and `Addable`
def showAndAdd[T: Show: Addable](x: T, y: T): String = {
  // Summon the implicit instances of `Show` and `Addable`
  // it works like `implicitly` in Scala 2
  val showInstance = summon[Show[T]]
  val addInstance = summon[Addable[T]]

  val sum = addInstance.add(x, y)
  s"The sum is: ${showInstance.show(sum)}"
}

given Show[Int] with {
  def show(value: Int): String = value.toString
}

given Addable[Int] with {
  def add(x: Int, y: Int): Int = x + y
}

@main def run(): Unit = {
  println(showAndAdd(3, 4))
}