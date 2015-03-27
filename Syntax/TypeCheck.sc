import scala.reflect.runtime.universe._

// type eraser for container
println((1,2).isInstanceOf[Tuple2[String, String]])
// how to get type match for template
def getTuple(): Tuple2[_, _] = {return (0,1)}
getTuple() match {
  case (_: String, _: String) => println("two strings")
  case (_: Int, _: Int) => println("two integers")
}

// how to get the type in template in run time
// <:< is deprecated in new version scala.
def foo[T](x: List[T])(implicit m: Manifest[T]) = {
  if (m <:< manifest[String])
    println("Hey, this list is full of strings")
  else
    println("Non-stringy list")
}

foo(List("one", "two")) // Hey, this list is full of strings
foo(List(1, 2)) // Non-stringy list
foo(List("one", 2)) // Non-stringy list

// get data type in runtime.
def paramInfo[T: TypeTag](x: T): Unit = {
  val targs = typeOf[T] match { case TypeRef(_, _, args) => args }
  println(s"type of $x has type arguments $targs")
}
paramInfo(42)

paramInfo(List(1, 2))

// classOf and get class.
class a {}
(new a).getClass == classOf[a]
// can't pass compilation since java don't support covariant
// val c: Class[a] = (new a).getClass


//
