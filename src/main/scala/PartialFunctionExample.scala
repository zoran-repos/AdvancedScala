val handleInt: PartialFunction[Any, String] = {
  case i: Int if i > 0 => s"Positive number: $i"
}

val handleString: PartialFunction[Any, String] = {
  case s: String => s"String with length: ${s.length}"
}

val handleSpecific: PartialFunction[Any, String] = {
  case 42 => "Special value: 42"
}


// Combining Pertial Functions with orElse
val combinedHandler: PartialFunction[Any, String] = handleInt orElse handleString orElse handleSpecific

object PartialFunctionExample {
  def main(args: Array[String]): Unit = {
    // Testiranje parcijalnih funkcija
    println(combinedHandler(10))
    println(combinedHandler("Hello"))
    println(combinedHandler(42))
    //isDefinedAt method is used to check if the partial function is defined for a given input
    if (handleInt.isDefinedAt(5)) {
      println(handleInt(5))
    }

    //println(combinedHandler(-5))    // Error is not defined for -5
  }
}