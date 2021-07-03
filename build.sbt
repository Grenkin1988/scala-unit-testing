import Dependencies._

ThisBuild / scalaVersion     := "2.13.5"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.h2"
ThisBuild / organizationName := "h2"

lazy val root = (project in file("."))
  .settings(
    name := "scala-unit-testing",
    libraryDependencies += scalaTest % Test
  )
