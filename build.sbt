name := "Scala RSS"

scalaVersion := "2.12.7"

triggeredMessage := Watched.clearWhenTriggered

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
