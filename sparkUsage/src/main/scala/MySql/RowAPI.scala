package main.scala.MySql

import MySql.TableGenerator
import org.apache.spark.SparkContext

import org.apache.spark.sql.catalyst.expressions.Row
import org.apache.spark.sql.{SchemaRDD, SQLContext}
import main.scala.Environment

/**
 * Created by junius on 15-3-1.
 */
object RowAPI {
  def main (args: Array[String]) {
    val sc = new SparkContext("local[4]", "Simple App") // An existing SparkContext.
    val sqlContext = new SQLContext(sc)
    sqlContext.setConf("spark.sql.dialect", "sql")

    TableGenerator.GenerateIntTable(sqlContext)
    import sqlContext._
    val rdd = sql("SELECT * FROM MyNumberPairs")
    rdd.foreach( row => println(row.getInt(0) + " and " + row.getInt(1)))
    println("++++++++++++++++++++")

    // map not supported by schema RDD or schema RDD can't map then generate a new schema RDD
    // because the logical plan or sql can not be compatible. for instance, we ++ each item of
    // number pair table. then the new data can not connect to any table.
    // val plusOneRdd = rdd.map[Row](

    // how to insert data to table. schema must be the same.
    // can't execute now maybe not supported yet.
    val memRdd = TableGenerator.GenerateMemRow(sqlContext)
    memRdd.insertInto("MyNumberPairs")

    println("++++++++++++++++++++")
    val rdd2 = sql("SELECT * FROM MyNumberPairs")
    rdd2.foreach( row => println(row.getInt(0) + " and " + row.getInt(1)))


  }
}
