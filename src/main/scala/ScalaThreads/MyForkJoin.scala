package ScalaThreads

import java.util.concurrent.ForkJoinPool

/**
 * Created by juzhou on 8/21/2015.
 */
object MyForkJoin {
  def main (args: Array[String]) {
    // the major difference with other java multi thread model is fork join
    // use work stealing algorithm / strategy for scheduling.
    val fj = new ForkJoinPool()
    // fj.execute()
  }
}
