package Recommedation

/**
 * item based collaborative filter
 */
object itemBasedCF {
  def main(args: Array[String]) {
    val userNum = 10
    val movieNum = 10
    val rank = new Array[Array[Double]](userNum) // rank matrix, default is -1. 0 to 5.

    // compute the similarity of two movies.
    def sim(m1: Int, m2: Int): Double = {
      // get all ranks of m1
      var index = 0
      val m1s = rank.map(arr => {
        index += 1
        (index, arr(m1))
      })

      // get all ranks of m2
      index = 0
      val m2s = rank.map(arr => {
        index += 1
        (index, arr(m1))
      })

      var sum1 = 0.0
      var sum2 = 0.0
      var sum3 = 0.0

      // for each customer. aggregate the both ranked.
      (0 until m1s.size).foreach(i => {
        if (m1s(i)._2 > 0 && m2s(i)._2 > 0) {
          sum1 += Math.pow(m1s(i)._2, 2)
          sum2 += Math.pow(m2s(i)._2, 2)
          sum3 += m1s(i)._2 * m2s(i)._2
        }
      })

      sum3 / Math.sqrt(sum1 * sum2)
    }

    // recommend for a customer with id.
    def recom(id: Int): Array[Int] = {
      var index = 0
      // choose movie not ranked
      val notRanked = rank(id).map(d => {
        index += 1
        (index, d)
      }).filter(_._2 < 0)

      (0 until notRanked.size).map(i => {
        val all = (0 until movieNum).map(j => (j, sim(notRanked(i)._1, j) * rank(id)(j)))
        val sum = all.map(_._2).sum
        val count = all.count(_ => true)
        (i, sum / count)
      }).sortBy(_._2).map(_._1).toArray
    }

  }
}
