// FindMax is function that uses a context bound for comparing elements
// This function takes two elements of type `T` and returns the larger
//      one using the `Ordering[T]` context bound

def findMax[T: Ordering](a: T, b: T): T = {

  // Obtain the implicit `Ordering[T]` using the `implicitly` clause
  // implicitly is a method defined in the Predef object
  // and it returns the implicit value of the given type
  // The `Ordering` type class provides comparison functions
  // this is trait that provides a way to compare instances of a type

  val ord = implicitly[Ordering[T]]
  // Use it to compare the elements
  if (ord.gt(a, b)) a else b
}

@main def runContextBound(): Unit = {
  println(findMax(10, 20))
  println(findMax("apple", "banana"))
}