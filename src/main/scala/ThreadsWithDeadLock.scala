import java.util.concurrent.locks.ReentrantLock

@main def threadDeadlock(): Unit = {
  val lock1 = new ReentrantLock()
  val lock2 = new ReentrantLock()

  // Thread 1 acquires lock1 and then tries to acquire lock2
  val thread1 = new Thread(() => {
    lock1.lock()
    try {
      println("Thread 1 acquired lock1, waiting for lock2...")
      Thread.sleep(100) // Simulate some work
      lock2.lock()
      try {
        println("Thread 1 acquired lock2")
      } finally {
        lock2.unlock()
      }
    } finally {
      lock1.unlock()
    }
  })

  // Thread 2 acquires lock2 and then tries to acquire lock1
  val thread2 = new Thread(() => {
    lock2.lock()
    try {
      println("Thread 2 acquired lock2, waiting for lock1...")
      Thread.sleep(100) // Simulate some work
      lock1.lock()
      try {
        println("Thread 2 acquired lock1")
      } finally {
        lock1.unlock()
      }
    } finally {
      lock2.unlock()
    }
  })

  thread1.start()
  thread2.start()
  thread1.join()
  thread2.join()
}