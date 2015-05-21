package MachineL.DataMining

// lesson learned. we should use sorted set to store all transaction.

object MyApriori {
  def main(args: Array[String]) {
    val t = TransactionGenerator.getTransaction(10, 6, 5)
    t.foreach(idTrans => println(idTrans._2))

    def scan(l: Seq[Seq[Int]]) : Seq[Seq[Int]] = {
      def ifInclude(s: Seq[Int]): Boolean = {
        val res = t.count(idTrans => (s.toSet -- idTrans._2.toSet).isEmpty) > 0
        //println(s, res)
        res
      }

      l.filter(s => ifInclude(s))
    }

    val itemOne = t.flatMap(idTrans => idTrans._2).distinct
    itemOne.foreach(println(_))

    val allItems = new Array[Seq[Seq[Int]]](3)
    val itemOneSeq = itemOne.map(item => Seq(item))
    allItems(0) = itemOneSeq

    (1 until 3).foreach(i => {
      val cur = i - 1
      val first = 0
      val itemI = allItems(cur).flatMap(s1 => {
        allItems(first).map(s2 => (s1.toSet[Int] ++ s2.toSet[Int]).toSeq)
      }).filter(_.size == i+1)

      allItems(i) = scan(itemI)
      println("###",i)
      allItems(i).foreach(println(_))
    })
  }
}
