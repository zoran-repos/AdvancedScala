object ThreadUtils {
  def startAndJoinThreads(threads: Thread*): Unit = {
    threads.foreach(_.start())
    threads.foreach(_.join())
  }
}

@main def simpleThreadWithoutRunnable(): Unit = {
  import ThreadUtils._

  val thread1 = new Thread {
    override def run(): Unit = {
      for i <- 1 to 3 do
        println(s"Thread 1 is running: count $i on ${Thread.currentThread().getName}")
        Thread.sleep(500) // 0.5 seconds
    }
  }

  val thread2 = new Thread {
    override def run(): Unit = {
      for i <- 1 to 3 do
        println(s"Thread 2 is running: count $i on ${Thread.currentThread().getName}")
        Thread.sleep(500) 
    }
  }

  // Start and join the threads using the utility function in ThreadUtils
  startAndJoinThreads(thread1, thread2)

  println("Both threads have finished execution.")
}
