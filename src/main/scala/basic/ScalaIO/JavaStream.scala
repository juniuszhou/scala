package ScalaIO

import java.io.{File, PrintWriter}

import scala.io.Source

/**
 * Created by junius on 15-3-14.
 */
object JavaStream {
  def main (args: Array[String]) {
    // character-output stream
    val w = new PrintWriter(new File("/home/junius/scalaIO.txt"))

    // read line from Console
    val line = Console.readLine()

    // read from file
    Source.fromFile(new File("/home/junius/scalaIO.txt")).foreach(println)


  }

}
