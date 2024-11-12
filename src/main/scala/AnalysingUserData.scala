@main def main(): Unit = {
  case class User(name: String, age: Int, income: Double)

  def filterByAge(users: List[User], minAge: Int): List[User] = {
    users.filter(_.age >= minAge) // First stage: filtering by age
  }

  def extractIncomes(users: List[User]): List[Double] = {
    users.map(_.income) // Second stage: extracting incomes
  }

  def calculateAverage(incomes: List[Double]): Double = {
    if (incomes.isEmpty) 0.0 else incomes.sum / incomes.length // Third stage: calculating average income
  }

  val users = List(
    User("Andrej", 30, 50000),
    User("Marija", 25, 40000),
    User("Petar", 35, 70000)
  )

  val averageIncome = calculateAverage(extractIncomes(filterByAge(users, 30)))
  println(s"Average income of users older than 30 years: $averageIncome")
}