import java.net.URL
import scala.concurrent.Future
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

object MyIO{
  def main (args: Array[String]) {
    //get data from URL
    //val url = new URL("http://www.baidu.com")
    //result is array of char
    //val baidu = Source.fromURL(url)

    // println(baidu.toString)

    // get data from file
    // iterator just work once. so if you just call size method.
    //then whole iterator will become empty. you can print nothing.
    val file = Source.fromFile("/home/junius/document")
    // println(file.getLines.size)

    //for (line <- file.getLines)
    //  print(line.length + " " + line)

    //file.getLines.toList.map(println)
    file.getLines.toList.flatMap(_.split(' ')).map(println)

    // source with future
    def readDoc(): Int = {
      val file = Source.fromFile("/home/junius/document")
      file.getLines.toList.flatMap(_.split(' ')).map(println)
      Thread sleep 1000
      // if throw an exception like code below, then f.onFailure will be called.
      // throw new NullPointerException
      100
    }

    val f = Future[Int] {
      readDoc
    }

    f.onSuccess {
      case _ => println("successful call file open")
    }

    f.onFailure {
      case _ => println("failed call file open")
    }

    println("async call issued")

    Thread sleep 3000

  }
}