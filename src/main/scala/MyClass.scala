class MyClass{
  def fun(str: String) {println(str)}
  def fun(i: Int) {println(i)}

}


object MyClass{
  def staticMethod = {println("static method")}
  def main (args: Array[String]) {
    val mc = new MyClass
    mc.fun(100)
    MyClass.staticMethod
    //how to use it in java
    //MyClass$.MODULE$.staticMethod


  }
}