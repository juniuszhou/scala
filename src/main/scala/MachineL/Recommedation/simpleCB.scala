package Recommedation

/**
 * simple content based RS implementation.
 */
class simpleCB {
  def main(args: Array[String]) {
    val userNum = 10
    val movieNum = 10
    val rank = new Array[Array[Double]](userNum) // rank matrix, default is -1. 0 to 5.

    val itemFeatureNum = 5 // each movie has 5 features.

    // it is first step get the value for each attribute
    val features = new Array[Array[Double]](movieNum)

    // http://en.wikipedia.org/wiki/Cosine_similarity
    def sim(arr1: Array[Double], arr2: Array[Double]): Double = {
      var sum1 = 0.0
      var sum2 = 0.0
      var sum3 = 0.0

      (0 until arr1.size).foreach(i => {
        sum1 += Math.pow(arr1(i), 2)
        sum2 += Math.pow(arr2(i), 2)
        sum3 += arr1(i) * arr2(i)
      })

      sum3 / Math.sqrt(sum1 * sum2)
    }

    // KNN , for new item.
    def profileLearning(itemAttriubtes: Array[Double], userId: Int): Double = {
      // first select the movies a user ranked
      val rankOfUser = rank(userId)
      var movieId = 0
      val ranked = rankOfUser.map(d => {
        movieId += 1
        (d, movieId)
      }).filter(_._1 > 0)
      // choose top 3 most similar
      val topN = ranked.map(p => (p._1, p._2, sim(features(p._2), itemAttriubtes))).sortBy(_._2).take(3)

      // sum all rank for topN similar items for a customer.
      val prediction = (0 until 3).map(i => rank(userId)(topN(i)._2)).sum
      prediction / 3
    }

    // we have some candidate movie for RS
    def recommend(movies: Array[Array[Double]], userId: Int): Array[Int] = {
      var newMovieId = 100
      val movieWithId = movies.map(arr => {
        newMovieId += 1
        (arr, newMovieId)
      })
      // recommend three movies for customer.
      movieWithId.map(arrId => (profileLearning(arrId._1, userId), arrId._2)).sortBy(_._1).take(3).map(_._2).toArray
    }
  }
}
