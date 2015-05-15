package TraitClass

/**
 * Created by junius on 15-2-2.
 */

abstract class AnonymousClass{
  val f: Int => Int
}
object AnonymousClass {
  def main (args: Array[String]) {
    val c = new AnonymousClass {
      val f = (i: Int) => i * 2
    }
    println(c.f(12))
  }
}
