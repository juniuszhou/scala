package Recommedation

object Similarity {
  def PerrsonSim(arr1: Array[Double],arr2: Array[Double]): Double = {
    val len = arr1.size
    val xMean = arr1.sum / len
    val yMean = arr2.sum / len
    val fenzi = (0 until len).map(i => (arr1(i) - xMean) * (arr2(i) - yMean)).sum
    val fenmu = (0 until len).map(i =>
      Math.pow(arr1(i) - xMean,2)  * Math.pow(arr2(i) - yMean, 2)).product
    fenzi / Math.sqrt(fenmu)
  }

  def PerrsonSim2(arr1: Array[Double],arr2: Array[Double]): Double = {
    val len = arr1.size
    val xMean = arr1.sum / len
    val yMean = arr2.sum / len
    val fenzi = arr1.zip(arr2).map(pair => (pair._1 - xMean)* (pair._2 - yMean)).sum
    val fenmu = (0 until len).map(i =>
      Math.pow(arr1(i) - xMean,2)  * Math.pow(arr2(i) - yMean, 2)).product
    fenzi / Math.sqrt(fenmu)
  }

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

  // compute the similarity of two sets. for instance, two sentences in NLP.
  def Jaccard(arr1: Array[Int], arr2: Array[Int]): Double = {
    val fenmu = (arr1 ++ arr2).distinct.length
    val fenzi = arr1.length + arr2.length - fenmu
    fenzi.toDouble / fenmu.toDouble
  }
}
