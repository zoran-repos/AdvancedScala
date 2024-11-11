case class LogLevel(level: String)

object LoggerExample {
  def logMessage(message: String)(implicit logLevel: LogLevel): Unit = {
    println(s"[${logLevel.level}] - $message")
  }

  def main(args: Array[String]): Unit = {
    // Defining the default log level as `INFO`
    implicit val defaultLogLevel: LogLevel = LogLevel("INFO")

    // Using the function without an explicit level
    logMessage("Application started.") 

    // Using the function with an explicit level
    logMessage("An error occurred.")(LogLevel("ERROR")) 
  }
}