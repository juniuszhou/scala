package Syntax

/**
 * Created by juzhou on 3/23/2015.
 */
object TypeScala {
  def f1[T >: Number](t: T) = {
    var a: Number = 1
    // a = t  // can't pass compilation
    println("f1 called")
  }
  def f2[T <: Number](t: T) = {
    var a: Number = 1
    a = t
    println("f2 called")
  }
  def main (args: Array[String]) {
    //f1(1)
    //f2(1)
  }
}
