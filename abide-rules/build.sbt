name := "abide-rules"

scalaVersion := "2.11.4"

organization := "com.github.dragos"

version := "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq("com.typesafe" %% "abide" % "0.1-SNAPSHOT",
              "org.scala-lang" % "scala-reflect" % "2.11.4",
              "org.scala-lang" % "scala-compiler" % "2.11.4")