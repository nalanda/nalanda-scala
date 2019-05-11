import org.ensime.EnsimeKeys._

name := "numerical-scala"

version := "1.0"


scalaVersion in ThisBuild := "2.11.8"

//scalaVersion := "2.11.8"


ensimeIgnoreScalaMismatch in ThisBuild := true

ensimeScalaVersion in ThisBuild := "2.11.8"

ensimeIgnoreMissingDirectories := true


//scalaVersion in ThisBuild := "2.11.8"



scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")

//mainClass in (Compile, run) := Some("com.squareoneinsights.ifrm.fraud.gaussian.FraudDetectionPipeline")
/*
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.3.1",
  "org.apache.spark" %% "spark-mllib" % "2.3.1",
  "org.apache.spark" %% "spark-sql" % "2.3.1"
)

*/
val sparkCore = "org.apache.spark" %% "spark-core" % "2.3.1"
val sparkSQL = "org.apache.spark" %% "spark-sql" % "2.3.1"
val sparkMllib = "org.apache.spark" %% "spark-mllib" % "2.3.1" //% "runtime"
//val sparkLocal = "org.apache.spark" %% "spark-mllib-local" % "2.4.0"
val typeSafe = "com.typesafe" % "config" % "1.3.3"
val sparkCassandraConnector = "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.0"
//val databricksCsv  = "com.databricks" %% "spark-csv" % "1.5.0"
val jodaTime = "joda-time" % "joda-time" % "2.10.1"
//val macWire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

libraryDependencies ++= Seq(sparkCore
  , sparkSQL
  , typeSafe
 , sparkCassandraConnector
  , jodaTime
   ,sparkMllib
  // ,databricksCsv
 // , macWire
)
resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
resolvers += "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
//fork in run := true
//fork in test := true



assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
