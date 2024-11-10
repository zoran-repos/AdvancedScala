object CoordinateExtractor {
  def unapply(input: String): Option[(Int, Int)] = {
    val parts = input.split(",")
    if (parts.length == 2) {
      try {
        Some((parts(0).trim.toInt, parts(1).trim.toInt))
      } catch {
        case _: NumberFormatException => None
      }
    } else None
  }
}

def describeCoordinates(input: String): String = input match {
  case CoordinateExtractor(x, y) => s"Koordinate su: x = $x, y = $y"
  case _ => "Nije validan format za koordinate"
}

object CoordinateMatcher {
  def main(args: Array[String]): Unit = {
    println(describeCoordinates("10, 20"))  
    println(describeCoordinates("10, twenty")) 
  }
}