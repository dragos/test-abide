import sbt._
import Keys._

object TestAbideBuild extends Build {
    lazy val root = Project(id = "test-abide",
                            base = file(".")) aggregate(abideRules, main)

    lazy val abideRules = Project(id = "abide-rules",
                           base = file("abide-rules"))

    lazy val main = Project(id = "main",
                           base = file("main")).dependsOn(abideRules % "abide")
			   .settings(libraryDependencies += "com.typesafe" %% "abide-core" % "0.1-SNAPSHOT" % "abide")
}
