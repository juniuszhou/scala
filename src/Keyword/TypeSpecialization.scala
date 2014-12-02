package Keyword

/**
 * Created by junius on 14-12-2.
 */
// for specialized key work just used for define trait OR abstract class.
// the benefit for define this way to avoid boxing and unboxing.
// because the template implemented via type eraser.

trait TypeSpec[@specialized(Int, Char) T]{
  def data: T
}

class IntType extends TypeSpec[Int]{
  @Override def data: Int = 0
}

class CharType extends TypeSpec[Char]{
  def data: Char = 'a'
}

object TypeSpecialization {

  def main (args: Array[String]) {
    val ts = new IntType
    println(ts.data)

    val tc = new CharType
    println(tc.data)
  }

}
