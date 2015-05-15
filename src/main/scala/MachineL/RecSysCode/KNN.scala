package RecSysCode

import scala.collection.parallel.mutable

/**
 * Created by juzhou on 4/23/2015.
 */
object KNN {
  def main(args: Array[String]) {
    val m = 10000 // 1000 users
    val n = 100 // 100 items
    val top = 20 // 20 neighbor involved predicate

    val rating = new Array[Array[Double]](n)
    // init rating matrix n * m. it reverse dimension make simple for item sim ops.
    (0 until n).foreach(i => rating(i) = new Array[Double](m))

    val itemMean = rating.map(arr => {
      val count = arr.count(_ > 0)
      arr.sum / count
    })

    def PerrsonSim(arr1: Array[Double], arr2: Array[Double]): Double = {
      val len = arr1.size
      val xMean = arr1.sum / len
      val yMean = arr2.sum / len
      val fenzi = (0 until len).map(i => (arr1(i) - xMean) * (arr2(i) - yMean)).sum
      val fenmu = (0 until len).map(i =>
        Math.pow(arr1(i) - xMean, 2) * Math.pow(arr2(i) - yMean, 2)).product
      fenzi / Math.sqrt(fenmu)
    }

    val itemSimMatrix = new Array[Array[Double]](n)
    (0 until n).foreach(i => itemSimMatrix(i) = new Array[Double](n))
    (0 until n).foreach(i => itemSimMatrix(i)(i) = 1)
    (0 until n).foreach(i => {
      (0 until i).foreach(j => {
        val v = PerrsonSim(rating(i), rating(j))
        itemSimMatrix(i)(j) = v
        itemSimMatrix(j)(i) = v
      })
    })

    def predicate(itemId: Int, userId: Int): Double = {
      var fenzi = 0.0
      var fenmu = 0.0
      //get vector of this user
      val ratedItems = rating.map(_(userId))
      // zip with item index
      val pairMap = for (itemId <- 0 until ratedItems.length) yield (itemId, ratedItems(itemId))
      //compute the similarity
      val withSim = pairMap.filter(_._2 > 0).map(p => (p._1, p._2, PerrsonSim(rating(p._1), rating(itemId))))
      // take top K
      val topItems = withSim.sortBy(_._3).take(top)

      //aggregate the bias
      topItems.foreach(p => {
        fenmu += Math.abs(p._3)
        fenzi += p._3 * (p._2 - itemMean(p._1))
      })

      var ret = 0.0
      ret = if (fenzi > 0.02) itemMean(itemId) + (fenzi / fenmu)
      else itemMean(itemId)
      ret
    }

  }
}
