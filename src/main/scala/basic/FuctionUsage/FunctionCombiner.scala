package basic.FuctionUsage

/**
 * Created by juzhou on 7/2/2015.
 */
object FunctionCombiner {
  def main (args: Array[String]) {
    val add = (x: Int) => x + 2
    val mul = (x: Int) => x * 5
    def compose[A,B,C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))
    val mulThenAdd = compose(add,mul)
    println(mulThenAdd(2))

    println((add compose mul)(2))

    def myAdd(x: Int, y: Int) = println(x+y)

    val l = List(1,2,3)
    l.scan(0)(_+_)

  }
}
