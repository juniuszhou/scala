package Recommedation

/**
 * Created by juzhou on 3/30/2015.
 * http://courses.cs.washington.edu/courses/csep521/07wi/prj/michael.pdf
 */

// http://www.evanmiller.org/how-not-to-sort-by-average-rating.html
class RankStars {
  def score(): Double = {
    val confidence = 0.95 // confidence for we get correct rank
    val z = confidence // should be the pnormaldist of normal distribution.
    val pos = 100 // positive rating
    val n = 200 // 200 is total rating,
    val phat = 1 * pos / n //
    val result = (phat + z * z / (2 * n) - z * Math.sqrt((phat * (1 - phat) + z * z / (4 * n)) / n)) / (1 + z * z / n)
    result
  }
}
