package MyStream

import scala.collection.mutable.SynchronizedQueue

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

object MyQueueStream {

  def main(args: Array[String]) {

    // StreamingExamples.setStreamingLogLevels()
    val sc = new SparkContext("local[4]", "Simple App")

    // val sparkConf = new SparkConf().setAppName("QueueStream")
    // Create the context
    val ssc = new StreamingContext(sc, Seconds(1))

    // Create the queue through which RDDs can be pushed to
    // a QueueInputDStream
    val rddQueue = new SynchronizedQueue[RDD[Int]]()

    // Create the QueueInputDStream and use it do some processing
    val inputStream = ssc.queueStream(rddQueue)
    val mappedStream = inputStream.map(x => (x % 10, 1))
    val reducedStream = mappedStream.reduceByKey(_ + _)
    reducedStream.print()
    ssc.start()

    // Create and push some RDDs into
    for (i <- 1 to 30) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 1000, 10)
      Thread.sleep(1000)
    }
    ssc.stop()
  }
}

