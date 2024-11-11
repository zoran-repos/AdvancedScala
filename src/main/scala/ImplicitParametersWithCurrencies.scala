case class NumberFormat(formatStyle: String)

object ImplicitExample {
  // Function that uses an implicit parameter for number formatting
  private def formatNumber(value: Int)(implicit numberFormat: NumberFormat): String = {
    numberFormat.formatStyle match {
      case "currency" => f"$$${value.toDouble}%.2f" 
      case "hex" => f"0x${value.toHexString.toUpperCase}"
      case _ => value.toString 
    }
  }

  def main(args: Array[String]): Unit = {
 
    implicit val originFormat: NumberFormat = NumberFormat("currency")
    //implicit val otherFormat: NumberFormat = NumberFormat("hex")
    
    println(formatNumber(100))
    //case _ => value.toString  in case of other format non currency or hex it will return the value as string
    println(formatNumber(100)(NumberFormat("custom"))) 

    // Using the function with explicitly passing the format
    println(formatNumber(100)(NumberFormat("hex"))) 
    
  }
}