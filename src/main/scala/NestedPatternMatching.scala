case class Address(street: String, city: String)
case class Person(name: String, age: Int, address: Address)

// Function with pattern matching that matches a Person object
def matchPerson(person: Person): String = person match {
  case Person(name, age, Address(street, city))
    if age >= 18 =>
    s"$name is an adult and lives on $street, $city."
  case Person(name, _, Address(street, _)) =>
    s"$name lives on some street aprox. $street."
}

object NestedPatternMatching {
  def main(args: Array[String]): Unit = {

    val person1 = Person("Ana", 25, Address("Pero Cico 11", "Kumanovo"))
    val person2 = Person("Marko", 16, Address("T. Gologanov 66", "Skopje"))

    println(matchPerson(person1))
    println(matchPerson(person2))
  }
}