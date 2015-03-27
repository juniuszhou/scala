// _ could used as default value. but can't be in stack, since
// instantiate is needed in stack.
class a{
  self =>
  val s: String = _
  class b{
    val s: String = _
    def b1 = {println(self.s + this.s)}
  }
}

val a1 = new a
println(a1.s)

//create a List include via :: static method of Object
// same as ::.apply()
val l = ::(1, Nil)
// create List via :: middle operator. same as Nil.::(1)
val l2 = 1 :: Nil

// try to change case to class to normal class.
case class op[A, B](a: A, b: B){def f=println(a); println(b)}
// create op object via middle operator style
val s: String op String = new op("a", "b")
// val s: String op String = "a" op "b" illegal
s match{
  case "a" op "b" => s.f
}

class order{
  // you can define two variable like this. but not in the body of method.
  // the reason is scalac compile it like this way. set a private data member
  // and a public method with the same name. so it can pass compilation.
  val latter: Int = prev + 1
  val prev: Int = 0
}



