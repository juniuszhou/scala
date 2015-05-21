package MachineL.DataMining
import java.util.Random

object TransactionGenerator {
  //val transactionNum = 1000
  //val maxItem = 50 // max item number for single transaction
  //val itemNumber = 300 // we have 300 different goods.
  def getTransaction(transactionNum: Int, maxItem: Int, itemNumber: Int): Seq[(Int, Seq[Int])] = {
    val r = new Random()
    def getOneTransaction: Seq[Int] = {
      val num = r.nextInt(maxItem)
      (0 until num).map( i => r.nextInt(itemNumber)).distinct // .sortBy(_)
    }
    getOneTransaction.getClass
    (0 until transactionNum).map(i => (i, getOneTransaction))
  }

  def main (args: Array[String]) {
    val s = Range(1,3,1)
    val l = IndexedSeq[Int](1)
    println(l)
  }
}
