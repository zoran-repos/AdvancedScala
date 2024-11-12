@main def mainWithComposition(): Unit = {
  case class User(name: String, age: Int, income: Double)

  def filterByAge(minAge: Int)(users: List[User]): List[User] = {
    users.filter(_.age >= minAge)
  }

  def extractIncomes(users: List[User]): List[Double] = {
    users.map(_.income)
  }

  def calculateAverage(incomes: List[Double]): Double = {
    if (incomes.isEmpty) 0.0 else incomes.sum / incomes.length
  }

  // Creating a functional chain
  val users = List(
    User("Andrej", 30, 50000),
    User("Marija", 25, 40000),
    User("Petar", 35, 70000)
  )

  // Using composition to chain functions together
  val averageIncomeFunction: List[User] => Double = filterByAge(30)
    .andThen(extractIncomes)
    .andThen(calculateAverage)

  val averageIncome = averageIncomeFunction(users)
  println(s"Average income of users older than 30 years: $averageIncome")
}