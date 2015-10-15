
organization := "nl.pvanassen.euler"

name := "scala"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.4"

traceLevel := -1

logLevel := Level.Info

// disable printing timing information, but still print [success]
// showTiming := false

// disable printing a message indicating the success or failure of running a task
// showSuccess := false

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

// disable updating dynamic revisions (including -SNAPSHOT versions)
// offline := true

seq(bintrayResolverSettings:_*)

libraryDependencies += "org.clapper" % "classutil_2.11" % "1.0.5"

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "0.1.1" withSources() withJavadoc()
