package RecSysCode

object SvdPlusPlus {
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

    val beta1 = 0.05 // regularization for bias
    val beta2 = 0.05 // regularization for feature

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

    // m times k matrix
    val userComCharacter = new Array[Array[Double]](m)
    (0 until m).foreach(i => userComCharacter(i) = new Array[Double](k))
    val implicitItemWeight = new Array[Array[Double]](n)
    (0 until n).foreach(i => implicitItemWeight(i) = new Array[Double](k))

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
        (0 until n).foreach(iItem => implicitItemWeight(iItem)(iFeature) = nextR)
      })
    }

    val biasUser = Array[Double](m)
    val biasItem = Array[Double](n)
    def globalMean(): Double = {
      rating.flatMap(arr => arr.map(rate => rate)).sum / (m * n)
    }
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



    def predictRating(userId: Int, itemId: Int): Double = {
      val sum = rating(userId).count(_ > 0)
      var ret = 0.0
      if (sum > 0) {
        ret = mean + biasUser(userId) + biasItem(itemId)
        +userComCharacter(userId).zip(itemFeature(itemId)).map(p => p._1 * p._2).sum
      } else ret = mean + biasUser(userId) + biasItem(itemId)

      if (ret > 5) ret = 5
      if (ret < 1) ret = 1
      ret
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
          //how many item rated by user. it is very important parameter as implicit data.
          //since Netflix doesn't provide any other implicit data so here just use if user rated
          // an item or not, regardless its value, as implicit data.
          val num = rating(userId).count(_ > 0)
          val sqrtNum = if (num > 0) 1 / Math.sqrt(num) else 0.0

          val sumQE = Array[Double](k)
          // compute the userComCharacter
          (0 until k).foreach(featureId => {
            var sum = 0.0
            // sum up the weight.
            (0 until n).foreach(itemId => if (rating(userId)(itemId) > 0) sum += implicitItemWeight(itemId)(featureId))
            userComCharacter(userId)(featureId) = userFeature(userId)(featureId) + sqrtNum * sum
          })

          (0 until n).foreach(itemId => {
            val bias = mean + biasUser(userId) + biasItem(itemId)
            val predict = predictRating(userId, itemId)
            val error = rating(userId)(itemId) - predict
            totalError += error

            // update bias
            biasUser(userId) += alpha1 * (error - beta1 * biasUser(userId))
            biasItem(itemId) += alpha1 * (error - beta1 * biasItem(itemId))

            // update feature matrix
            (0 until k).foreach(featureId => {
              userFeature(userId)(featureId) += alpha2 *
                (error * itemFeature(itemId)(featureId) - beta2 * userFeature(userId)(featureId))
              itemFeature(itemId)(featureId) += alpha2 *
                (error * userComCharacter(userId)(featureId) - beta2 * itemFeature(itemId)(featureId))
              sumQE(featureId) += error * itemFeature(itemId)(featureId)
            })
          })

          // update weight vector
          (0 until n).foreach(itemId => {
            (0 until k).foreach(featureId => {
              implicitItemWeight(itemId)(featureId) +=
                alpha2 * (sqrtNum * sumQE(featureId) - beta2 * implicitItemWeight(itemId)(featureId))
            })
          })

          // update loop condition variable.
          gapLastTwoIteration = Math.abs(totalError - lastTotalError)
          lastTotalError = totalError
          round += 1

          alpha1 *= slowRate
          alpha2 *= slowRate

        })
      }
    }

    // start to run.
    initFeature()
    initBias()
    train()
  }
}
