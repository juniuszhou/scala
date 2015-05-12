package Recommedation

object MySVD {
  def main(args: Array[String]) {
    val m = 10000 // 100 users
    val n = 100 // 100 items
    val k = 20 // 20 features
    val learnSpeed = 0.001
    val regulization = 0.1

    // in fact, the two dimension data structure is not good. since it is very sparse.
    val rating = new Array[Array[Double]](m)
    // init rating matrix
    (0 until m).foreach(i => rating(i) = new Array[Double](n))
    //init use feature
    val userFeature = new Array[Array[Double]](k)
    (0 until k).foreach(i => userFeature(i) = new Array[Double](m))
    //init item feature
    val itemFeature = new Array[Array[Double]](k)
    (0 until k).foreach(i => itemFeature(i) = new Array[Double](n))

    def predictRating(userId: Int, itemId: Int): Double = {
      var sum = 1.0
      (0 until k).foreach(i => sum += userFeature(k)(userId) * itemFeature(k)(itemId))
      if (sum > 5) sum = 5
      if (sum < 1) sum = 1
      sum
    }

    def train() = {
      // minimum gap we think convegenced if gap between iteration less than it.
      val MIN_IMPROVEMENT = 0.0001
      val MAX_ITERATION = 50 // max iterations until stop.
      def computeRmse(userId: Int, itemId: Int): Double = {
        val a = rating(userId)(itemId) - predictRating(userId, itemId)
        a
        // Math.pow(a, 2)
      }
      //start to train each feature.
      (0 until k).foreach(i => {

        var gapLastTwoIteration = 1.0
        var round = 0
        while (round < MAX_ITERATION && gapLastTwoIteration > MIN_IMPROVEMENT) {
          //get the totalError
          var lastTotalError = 0.0
          var totalError = 0.0
          (0 until m).foreach(userId => {
            (0 until n).foreach(itemId => {
              val rmse = computeRmse(userId, itemId)
              totalError += rmse * rmse

              // keep old value
              val oldUser = userFeature(k)(userId)
              val oldItem = itemFeature(k)(itemId)

              //update the feature factor
              userFeature(i)(userId) += learnSpeed * (rmse * oldItem - regulization * oldUser)
              itemFeature(i)(itemId) += learnSpeed * (rmse * oldUser - regulization * oldItem)
            })
          })

          // update loop condition variable.
          gapLastTwoIteration = Math.abs(totalError - lastTotalError)
          lastTotalError = totalError
          round += 1
        }

      })
    }

  }
}
