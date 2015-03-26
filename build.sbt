name := "scala"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.2-M1"

libraryDependencies += "org.scalatest" % "scalatest_2.9.1" % "1.8"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.3.0"

libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.3.0"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.3.0"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "1.3.0"
