package ScalaIO

/**
 * Created by junius on 15-3-3.
 */
object ScalaInputOutput {

  def outputEachLine(): Unit ={
    for(ln <- io.Source.stdin.getLines()) println(ln)
  }
  def main (args: Array[String]) {
    outputEachLine()
    return
    var ok: Boolean = true
    while (ok) {
      val ln = readLine()
      ok = ln != null
      if (ok) println(ln)
    }
  }

}
