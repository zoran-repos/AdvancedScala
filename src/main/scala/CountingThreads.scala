@main def threadCountingExample(): Unit = {

  def startCounting(name: String, countUntil: Int): Thread =
    Thread(() => {
      for i <- 1 to countUntil do
        println(s"Thread $name counting: $i")
        Thread.sleep(500) // Simulate work
      println(s"Thread $name completed counting.")
    })

  // Create and start two threads
  val thread1 = startCounting("A", 5)
  val thread2 = startCounting("B", 3)

  // Start the threads
  thread1.start()
  thread2.start()

  // Wait for threads to complete
  thread1.join()
  thread2.join()

  println("Both threads have finished execution.")
}
