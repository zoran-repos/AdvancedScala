// Define a generic trait Transformer that works with a type constructor F[_]
trait GenericTransformer[F[_]] {
  // Method to transform a value of type A into a structure of type F[B]
  def transform[A, B](value: A, func: A => B): F[B]
}


object GenericTransformerInstances {

  given genericListTransformer: GenericTransformer[List] with {
    def transform[A, B](value: A, func: A => B): List[B] = List(func(value))
  }
  
  given genericOptionTransformer: GenericTransformer[Option] with {
    def transform[A, B](value: A, func: A => B): Option[B] = Some(func(value))
  }
}

// Define a generic function that uses a GenericTransformer to transform values into a structure of type F
// It takes an implicit GenericTransformer instance to determine how to perform the transformation
def genericTransform[F[_], A, B](value: A, func: A => B)(using transformer: GenericTransformer[F]): F[B] = {
  transformer.transform(value, func) 
}

import GenericTransformerInstances.given

val listResult = genericTransform[List, Int, String](10, _.toString)     
val optionResult = genericTransform[Option, Double, Int](3.14, _.toInt)  


@main def runHigherKindedType(): Unit = {
  println(listResult)    
  println(optionResult)  
}