case class LogLevel(level: String)

object LoggerExample {
  private def logMessage(message: String)(implicit logLevel: LogLevel): Unit = {
    println(s"[${logLevel.level}] - $message")
  }

  def main(args: Array[String]): Unit = {
    // Defining the default log level as `INFO`
    implicit val defaultLogLevel: LogLevel = LogLevel("INFO")
    // this will be Ambiguous implicit values:
    // both value defaultLogLevel of type LogLevel and value defaultLogLevel2 of type LogLevel
    // match expected type LogLevel

    //implicit val defaultLogLevel2: LogLevel = LogLevel("DEBUG")

    // Using the function without an explicit level
    logMessage("Application started.") 

    // Using the function with an explicit level
    logMessage("An error occurred.")(LogLevel("ERROR")) 
  }
}