
class Animal {
  def speak(): Unit = println("Some generic animal sound")
}

class Dog extends Animal {
  override def speak(): Unit = println("Bark!")
}

// Covariant container
class Cage[+A](animal: A) {
  def get: A = animal
}

// Contravariant function
class Feeder[-A] {
  def feed(animal: A): Unit = println("Feeding an animal")
}

// Invariant container
// The Holder class is invariant because it has both a covariant and a contravariant method
// The get method is covariant because it returns an item of type A
// The set method is contravariant because it takes an item of type A as a parameter
class Holder[A](private val item: A) {
  def get: A = item
  def set(newItem: A): Unit = {
    // this means that we can only replace the item with a new one of the same type
    println(s"Replaced item with a new one of the same type.")
  }
}

@main def varianceExample(): Unit = {
  // Covariance: The Cage class is covariant in its type parameter A (denoted by +A).
  // This means that Cage[Dog] can be assigned to Cage[Animal].
  // Polymorphism: When you assign dogCage (which is of type Cage[Dog]) to animalCage
  // (which is of type Cage[Animal]), the actual object inside animalCage is still a Dog.
  val dogCage: Cage[Dog] = new Cage(new Dog)
  val animalCage: Cage[Animal] = dogCage
  println(animalCage.get.speak())

  // Contravariance allows Feeder[Animal] to accept Feeder[Dog]
  val animalFeeder: Feeder[Animal] = new Feeder[Animal]
  val dogFeeder: Feeder[Dog] = animalFeeder
  dogFeeder.feed(new Dog)

  // Invariance example: Holder[A] does not support type substitution
  val dogHolder: Holder[Dog] = new Holder(new Dog)
  // val animalHolder: Holder[Animal] = dogHolder // This would cause a compilation error due to invariance
  println(dogHolder.get.speak())
  println(dogHolder.set(new Dog))

}
