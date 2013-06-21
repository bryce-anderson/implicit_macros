import sbt._
import Keys._


object Settings {
  
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "bryce-anderson",
    version := "0.1.0",
    scalaVersion := "2.10.2-RC1",
    scalacOptions ++= Seq(),
    libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
  )
}

object build extends Build {

  lazy val macros: Project = Project(
    id = "macros",
    base = file("macros"),
    settings = Settings.buildSettings
  )
  
  lazy val main: Project = Project(
    id = "main",
    base = file("main"),
    settings = Settings.buildSettings
  ) dependsOn(macros)
  
}

