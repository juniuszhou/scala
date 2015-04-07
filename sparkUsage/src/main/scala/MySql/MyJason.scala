package MySql

import main.scala.Environment
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object MyJason {
  def main (args: Array[String]) {
    val sc = new SparkContext("local[4]", "Simple App") // An existing SparkContext.
    val sqlContext = new SQLContext(sc)
    val path = Environment.PATH + "examples/src/main/resources/people.json"

    val people = sqlContext.jsonFile(path)

    people.printSchema()
    people.registerTempTable("people")
    // to keep table in cache and accelerate its read and write.
    sqlContext.cacheTable("people")

    // other method to create json RDD
    val anotherPeopleRDD = sc.parallelize(
      """{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}""" :: Nil)
    val anotherPeople = sqlContext.jsonRDD(anotherPeopleRDD)
    anotherPeople.registerTempTable("other people")
    println(anotherPeople.toString())
    anotherPeople.map(println).count()
    sc.stop
  }
}
