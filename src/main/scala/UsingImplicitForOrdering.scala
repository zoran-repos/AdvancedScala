// Type class for comparing objects
trait Ordering[T] {
  def compare(x: T, y: T): Int
}

object OrderingInstances {

  implicit object IntOrdering extends Ordering[Int] {
    def compare(x: Int, y: Int): Int = x - y
  }
  
  implicit object StringOrdering extends Ordering[String] {
    def compare(x: String, y: String): Int = x.length - y.length
  }
}

def compareValues[T](x: T, y: T)(implicit ordering: Ordering[T]): String = {
  val result = ordering.compare(x, y)
  if (result > 0) s"$x is greater than $y"
  else if (result < 0) s"$x is less than $y"
  else s"$x is equal to $y"
}

object CompareValuesExample {
  def main(args: Array[String]): Unit = {
    import OrderingInstances._

    println(compareValues(10, 5))        
    println(compareValues("ScaleFocus", "Microsoft")) 
  }
}