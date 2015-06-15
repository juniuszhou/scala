package basic.Contrainer

/**
 * Created by juzhou on 6/8/2015.
 */
object StringBuffer {
  def main(args: Array[String]) {
    // string buffer from java jdk directly
    val sb = new StringBuffer
    sb.append("hello")
    sb.insert(2, "world")
    println(sb.toString)

    // build is not thread safe.
    val stb = new StringBuilder
    stb.append("hello")
    stb.insert(2, "world")
    println(stb.toString())
  }
}
