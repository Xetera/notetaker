name := "notetaker"

version := "0.1"

scalaVersion := "2.12.8"
scalacOptions += "-Ypartial-unification"

libraryDependencies += "es.nitaur.markdown" % "txtmark" % "0.16"
libraryDependencies += "org.typelevel" %% "cats-core" % "1.6.0"
libraryDependencies += "com.google.apis" % "google-api-services-drive" % "v3-rev20190311-1.28.0"
