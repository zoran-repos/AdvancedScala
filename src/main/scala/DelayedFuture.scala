import scala.concurrent.{Future, Promise, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Random, Success, Failure}


def asyncTaskWithFuture(): Future[String] = Future {
  println("Starting async task...")
  Thread.sleep(1500)
  "Async task completed"
}


def asyncTaskWithPromise(): Future[String] = {
  val promise = Promise[String]()

  // Simulates some asynchronous operation that completes after some delay
  Future {
    Thread.sleep(1000) // Simulated delay for completing the promise
    if (Random.nextBoolean()) {
      promise.success("Promise task completed successfully!")
    } else {
      promise.failure(new Exception("Promise task failed"))
    }
  }

  promise.future
}

object SimpleFuturePromiseExample {
  def main(args: Array[String]): Unit = {
    val futureResult = asyncTaskWithFuture()
    val promiseResult = asyncTaskWithPromise()

    futureResult.onComplete {
      case Success(message) => println(s"Future result: $message")
      case Failure(exception) => println(s"Future failed with: ${exception.getMessage}")
    }

    promiseResult.onComplete {
      case Success(message) => println(s"Promise result: $message")
      case Failure(exception) => println(s"Promise failed with: ${exception.getMessage}")
    }

    // Ensures main thread waits for both tasks to complete (only for demonstration purposes)
    Await.result(Future.sequence(Seq(futureResult, promiseResult)), 5.seconds)
  }
}
