import sbt._
import sbt.Keys._

name := "AdvancedScala"

version := "0.1"

scalaVersion := "3.5.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.15" % Test
)