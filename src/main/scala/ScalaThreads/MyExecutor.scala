package ScalaThreads

import java.util.concurrent.TimeUnit._
import java.util.concurrent.{ThreadFactory, BlockingQueue, ThreadPoolExecutor, Executors}

/**
 * Created by juzhou on 8/21/2015.
 */
object MyExecutor {
  def main (args: Array[String]) {

    def cache() = {
      val e = Executors.newCachedThreadPool()
    }
    def single() = {
      val e = Executors.newSingleThreadExecutor()
    }

    def multi() = {
      val e = Executors.newFixedThreadPool(10)
    }

    // start a thread which will run periodically. like each 1 minute
    def sched() = {
      val e = Executors.newScheduledThreadPool(10)
    }

    /*
     public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory)
     */


  }
}
