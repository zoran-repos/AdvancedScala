// Define a type constructor and a higher-kinded type in Scala
// A type constructor is a type that takes another type as a parameter to produce a concrete type.
// For example, List is a type constructor that takes a type parameter to produce a concrete type like List[Int] or List[String].
// A higher-kinded type is a type constructor that takes another type constructor as a parameter.

trait WrapperContainer[F[_]] {
  // Method to wrap a value of type A into a structure of type F[A]
  def wrap[A](value: A): F[A]
}

// Define an object that contains instances of Wrapper for List and Option
object WrapperInstancesNew {
  given listWrapper: WrapperContainer[List] with {
    def wrap[A](value: A): List[A] = List(value)
  }

  given optionWrapper: WrapperContainer[Option] with {
    def wrap[A](value: A): Option[A] = Some(value)
  }
}

def wrapValueInContainerNew[F[_], A](value: A)(using wrapper: WrapperContainer[F]): F[A] = {
  wrapper.wrap(value)
}


import WrapperInstancesNew.given


val wrappedInListNew = wrapValueInContainerNew[List, Int](42)
val wrappedInOptionNew = wrapValueInContainerNew[Option, String]("Hi")

@main def runNew(): Unit = {
  println(wrappedInListNew)
  println(wrappedInOptionNew)
}