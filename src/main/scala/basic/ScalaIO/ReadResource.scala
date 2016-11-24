package basic.ScalaIO

import main.scala

/**
 * Created by juzhou on 7/29/2015.
 */
object ReadResource {
  def main (args: Array[String]) {
    // the / absolute path is important, otherwise can't find the file except you didn't put
    // the scala source file under src.
    val stream = getClass.getResourceAsStream("/config.txt")
    val lines = scala.io.Source.fromInputStream( stream ).getLines
    lines.foreach(println)


  }
}
