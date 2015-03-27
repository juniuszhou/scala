import scala.collection.immutable.HashMap
import scala.io.Source

object Solution2 {
  def main(args: Array[String]) {
    val r = Source.fromFile("D:\\a1.txt").bufferedReader()
    var ss: String = r.readLine()
    var m = new HashMap[Int, List[Int]]()
    while(ss != null){
      println(ss)
      val l = ss.split("\t").toList.map(s => if(s == null || s.isEmpty) "0" else s).map(_.toInt)
      val id = l.head
      val rates = l.tail
      m += (id -> rates)

      ss = r.readLine()
    }

    m.map(idRates => (idRates._1, idRates._2.sum)).toArray.sortBy(_._2).foreach(println)

  }
}
