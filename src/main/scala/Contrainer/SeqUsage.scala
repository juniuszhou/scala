package Contrainer

object SeqUsage {
  def main(args: Array[String]) {
    val s1 = Seq[Int](1, 2, 3)
    val s2 = Seq[Int](4, 5, 6)
    (s1 ++ s2).foreach(i => println(i))

    //how to zip
    s1.flatMap(i => {
      s2.map(j => i * 100 + j)
    }).foreach(println(_))
  }
}
