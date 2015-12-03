package MyJson
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * https://github.com/json4s/json4s
 */
object Json4sUsage {
  def main(args: Array[String]){
    val v = parse(""" { "numbers" : [1, 2, 3, 4] } """)
    //val l = v.asInstanceOf[List[String]]
    //l.head

    println(v)
  }
}
