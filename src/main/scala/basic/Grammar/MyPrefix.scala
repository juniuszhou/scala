package Grammar

/**
 * Created by junius on 15-2-11.
 */
object MyPrefix {
  def main (args: Array[String]) {
    var s = "hello"
    // how to put a variable context into a string.
    val s2 = s"$s AS "
    println(s2)
    s = "world"
    // after change value, the output is the same. so it is static binding.
    println(s2)

    val s3 = s"$s AS "
    println(s3)
  }
}
