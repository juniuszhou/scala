package Recommedation

// http://amix.dk/blog/post/19574
// http://amix.dk/blog/post/19588
object HackerNews {
  def rank(): Double = {
    val p = 100 // how many points a news get from reader
    val t = 24 // how many hours passed since news submitted
    val g = 1.8 // gravity an experience value.

    val score = (p-1).toDouble / Math.pow((t+2),g)
    score
  }

  def main (args: Array[String]) {

  }
}
