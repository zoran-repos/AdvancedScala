import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Failure, Success}
import scala.concurrent.Await
import scala.concurrent.duration._

object ParallelApiCall {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContext = ExecutionContext.global

    // Simulate API call that may succeed or fail
    def apiCall(id: Int): Future[String] = Future {
      if (id % 2 == 0) throw new RuntimeException(s"API call $id failed")
      else s"API call $id succeeded"
    }

    // Parallel API calls
    val apiCalls: Seq[Future[String]] = (1 to 5).map(apiCall)

    // Handle successes and failures
    val combinedResponses = Future.sequence(apiCalls.map(_.recover {
      case ex: Exception => s"Recovered from failure: ${ex.getMessage}"
    }))

    combinedResponses.onComplete {
      case Success(responses) =>
        println(s"All API calls completed with responses: $responses")
      case Failure(exception) =>
        println(s"Some calls failed with exception: $exception")
    }

    // Blocking for demonstration purposes
    Await.result(combinedResponses, 10.seconds)
  }
}