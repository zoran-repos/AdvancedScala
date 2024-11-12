
// Define a type constructor and a higher-kinded type in Scala
// A type constructor is a type that takes another type as a parameter to produce a concrete type.
// For example, List is a type constructor that takes a type parameter to produce a concrete type like List[Int] or List[String].
// A higher-kinded type is a type constructor that takes another type constructor as a parameter.

trait Wrapper[F[_]] {
  // Method to wrap a value of type A into a structure of type F[A]
  def wrap[A](value: A): F[A]
}

// Define an object that contains instances of Wrapper for List and Option
object WrapperInstances {
  implicit val listWrapper: Wrapper[List] = new Wrapper[List] {
    def wrap[A](value: A): List[A] = List(value)
  }

  implicit val optionWrapper: Wrapper[Option] = new Wrapper[Option] {
    def wrap[A](value: A): Option[A] = Some(value)
  }
}


def wrapValueInContainer[F[_], A](value: A)(implicit wrapper: Wrapper[F]): F[A] = {
  wrapper.wrap(value)
}


import WrapperInstances._


val wrappedInList = wrapValueInContainer[List, Int](42)


val wrappedInOption = wrapValueInContainer[Option, String]("Hi")

object Main extends App {
  println(wrappedInList)
  println(wrappedInOption)
}