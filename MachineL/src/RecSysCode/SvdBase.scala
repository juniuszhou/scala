package RecSysCode

/**
 * Created by juzhou on 4/22/2015.
 */
object SvdBase {
  def main(args: Array[String]) {
    val m = 10000 // 1000 users
    val n = 100 // 100 items
    val k = 20 // 20 features
    val slowRate = 0.9 // reduce the learning rate gradually.

    /* parameter value for netflix.
    float alpha1 = 0.008;    //according suggestion of xlvector
    float alpha2 = 0.008;    //according suggestion of xlvector
    float beta1  = 0.01;     //according suggestion of xlvector
    float beta2  = 0.01;     //according suggestion of xlvector
     */
    var alpha1 = 0.01 // learnSpeed for bias
    var alpha2 = 0.01 // learnSpeed for feature

    val beta1 = 0.05  // regularization for bias
    val beta2 = 0.05  // regularization for feature

    // in fact, the two dimension data structure is not good. since it is very sparse.
    // we can introduce vector lib which support sparse vector to replace it.
    val rating = new Array[Array[Double]](m)
    // init rating matrix
    (0 until m).foreach(i => rating(i) = new Array[Double](n))
    //init use feature
    val userFeature = new Array[Array[Double]](k)
    (0 until k).foreach(i => userFeature(i) = new Array[Double](m))
    //init item feature
    val itemFeature = new Array[Array[Double]](k)
    (0 until k).foreach(i => itemFeature(i) = new Array[Double](n))

    def initFeature() = {
      val r = new util.Random()
      def nextR: Double = {
        val bigInt = 1000000000
        // get random double between 0 and 1.
        val d = r.nextInt(bigInt).toDouble / bigInt
        0.1 * Math.abs(d) * Math.sqrt(k)
      }

      (0 until k).foreach(iFeature => {
        (0 until m).foreach(iUser => userFeature(iUser)(iFeature) = nextR)
        (0 until n).foreach(iItem => itemFeature(iItem)(iFeature) = nextR)
      })
    }

    val biasUser = Array[Double](m)
    val biasItem = Array[Double](n)

    val mean = globalMean()
    def initBias() = {
      // n items, each indicate how many rate the item got.
      val userRatedItems = Array[Int](n)
      // sum up for each item.
      (0 until m).foreach(i => {
        (0 until n).foreach(j => {
          if (rating(i)(j) > 0) {
            biasItem(j) += rating(i)(j) - mean
            userRatedItems(j) += 1
          }
        })
      })

      // init the item bias
      (0 until n).foreach(i => if (userRatedItems(i) == 0)
        biasItem(i) = 0.0
      else biasItem(i) = biasItem(i) / userRatedItems(i) + 25)

      // an user rate how many items
      val itemRatedByUsers = Array[Int](m)
      (0 until m).foreach(i => {
        (0 until n).foreach(j => {
          if (rating(i)(j) > 0) {
            // attention. here need put the item bias into consideration.
            biasUser(i) += rating(i)(j) - mean - biasItem(j)
            itemRatedByUsers(i) += 1
          }
        })
      })

      // init the item bias
      (0 until m).foreach(i => if (itemRatedByUsers(i) == 0)
        biasUser(i) = 0.0
      else biasUser(i) = biasUser(i) / itemRatedByUsers(i) + 10)
    }

    def globalMean(): Double = {
      rating.flatMap(arr => arr.map(rate => rate)).sum / (m * n)
    }

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
        val rate = rating(userId)(itemId)
        if (rate > 0) rate - predictRating(userId, itemId) else 0.0
      }

      var gapLastTwoIteration = 1.0
      var round = 0
      while (round < MAX_ITERATION && gapLastTwoIteration > MIN_IMPROVEMENT) {

          var lastTotalError = 0.0
          var totalError = 0.0
          (0 until m).foreach(userId => {
            (0 until n).foreach(itemId => {
              val rmse = computeRmse(userId, itemId)
              val rmseSquare = rmse * rmse
              totalError += rmseSquare

              // keep old value
              val oldUser = userFeature(k)(userId)
              val oldItem = itemFeature(k)(itemId)

              // update the bias
              biasUser(userId) += alpha1 * (rmse - beta1 * biasUser(userId))
              biasItem(itemId) += alpha1 * (rmse - beta1 * biasItem(itemId))

              //update the feature one by one.
              (0 until k).foreach(i => {
                userFeature(i)(userId) += alpha2 * (rmse * oldItem - beta2 * oldUser)
                itemFeature(i)(itemId) += alpha2 * (rmse * oldUser - beta2 * oldItem)
              })
            })
          })

          // update loop condition variable.
          gapLastTwoIteration = Math.abs(totalError - lastTotalError)
          lastTotalError = totalError
          round += 1

        alpha1 *= slowRate
        alpha2 *= slowRate
      }
    }

    // start to run.
    initFeature()
    initBias()
    train()
  }
}
