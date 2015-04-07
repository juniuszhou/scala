import scala.collection.JavaConverters._

object JavaScala{
  def main (args: Array[String]) {
    // java basic type
    val s: java.lang.String = new java.lang.String()
    println(s)

    //val arr: java.



    val list: java.util.List[Int] = Seq(1,2,3,4).asJava
    val buffer: scala.collection.mutable.Buffer[Int] = list.asScala
    println(buffer)
  }
}