class MyClass{
  def fun(str: String) {println(str)}
  def fun(i: Int) {println(i)}

}

//we can define a abstract class with type parameter
abstract class MyAbstractClass{
  type T
  def a
}

object MyClass{
  def staticMethod = {println("static method")}
  def main (args: Array[String]) {
    val mc = new MyClass
    mc.fun(100)
    MyClass.staticMethod
    //how to use it in java
    //MyClass$.MODULE$.staticMethod

    // we can new an anonymous concrete class by define its type.
    val mac: MyAbstractClass = new MyAbstractClass{
      type T = Int
      def a =  println('a')
      override def toString() = "anonymous class"
    }

    println(mac.toString)

  }
}