name := "scala"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "rediscala" at "http://dl.bintray.com/etaty/maven"

libraryDependencies += "com.etaty.rediscala" % "rediscala" % "1.4.0"
