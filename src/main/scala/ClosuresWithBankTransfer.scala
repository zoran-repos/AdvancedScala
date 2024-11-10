def createBankAccount(initialBalance: Double): (Double => Double, Double => Double) = {
  // Internal function that uses closure to store the balance
  def updateBalance(balance: Double): (Double => Double, Double => Double) = {
    // Function for adding funds
    val deposit = (amount: Double) => {
      val newBalance = balance + amount
      println(s"Deposit: $amount, New balance: $newBalance")
      newBalance
    }

    val withdraw = (amount: Double) => {
      val newBalance = balance - amount
      if (newBalance < 0) {
        println(s"Insufficient funds. Withdrawal of $amount not possible.")
        balance
      } else {
        println(s"Withdrawal: $amount, New balance: $newBalance")
        newBalance
      }
    }
    // Returns functions that "close over" the current balance state
    (deposit, withdraw)
  }

  // Initial account balance
  updateBalance(initialBalance)
}

@main def mainBankAccount(): Unit = {
  // Creating a new bank account with an initial balance of 100
  val (deposit, withdraw) = createBankAccount(100)

  // Using functions to interact with created bank account
  val newBalance1 = deposit(50)  
  val newBalance2 = withdraw(30) 
  val newBalance3 = withdraw(200)
}