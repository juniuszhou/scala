package Grammar

/**
 * Created by junius on 15-1-3.
 */
object Functor {
  def pAndF(str: String)(f: Int => Int): Unit ={
    val i = 1
    println(str + " " + f(i))
  }
  def main (args: Array[String]) {
    pAndF("hello ")(i => i * 2)
    // if just one line function we can define in ()
    // we must use {} for more than one lines function to apply.
    pAndF("world ") {
      i => val j = i * 2
        println(j)
        j
    }
  }
}
