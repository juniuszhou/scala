package HackerRank

/**
 * Created by juzhou on 3/31/2015.
 */
object statistics {
  def main (args: Array[String]) {
    val arr = (0 until 1000).map(i => readLine().trim().toDouble)
    println(arr.count(d => d < 60))
    println(arr.count(d => d > 60 && d < 100))
    println(arr.count(d => d > 100 && d < 300))
    println(arr.count(d => d > 300 && d < 1000))
    println(arr.count(d => d > 1000))
  }
}
