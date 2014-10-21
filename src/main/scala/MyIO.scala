import java.net.URL

import scala.io.Source

object MyIO{
  def main (args: Array[String]) {
    //get data from URL
    val url = new URL("http://www.baidu.com")
    //result is array of char
    val baidu = Source.fromURL(url)

    println(baidu.toString)

  }
}