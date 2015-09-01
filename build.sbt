// use sbt-dev-settings to configure

import com.nitro.build._

import PublishHelpers._

// GAV

organization := "io.malcolmgreaves"

name := "pdfXtk"

lazy val semver = SemanticVersion(0, 9, 0, isSnapshot = true)

version := semver.toString

// scala & java

//                         :::   NOTE   :::
// we want to update to JVM 8 ASAP !
// since we know that we want to be able to use this stuff w/ Spark,
// we unfortunately have to limit ourselves to jvm 7.
// once this gets resolved, we'll update: 
// [JIRA Issue]     https://issues.apache.org/jira/browse/SPARK-6152

lazy val devConfig = {
  import CompileScalaJava._
  Config.spark
}

CompileScalaJava.librarySettings(devConfig)

javacOptions := Seq.empty[String]

javaOptions := JvmRuntime.settings(devConfig.jvmVer)

// dependencies and their resolvers

resolvers := Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "commons-collections" % "commons-collections" % "3.1"
  , "commons-lang" % "commons-lang" % "2.4"
  , "commons-io" % "commons-io" % "2.4"
  , "xstream" % "xstream" % "1.2.2"
  , "org.apache.pdfbox" % "pdfbox" % "1.8.1"
  , "org.apache.pdfbox" % "fontbox" % "1.8.1"
  , "org.apache.pdfbox" % "pdfbox-app" % "1.8.1"
  , "log4j" % "log4j" % "1.2.14"
  //, "javax.media.jai" % "com.springsource.javax.media.jai.core" % "1.1.3"
  //, "javax.media.jai" % "com.springsource.javax.media.jai.codec" % "1.1.3"
  , "com.github.jai-imageio" % "jai-imageio-core" % "1.3.0"
  , "xerces" % "xerces" % "2.4.0"
  // testing
  , "junit" % "junit" % "4.11" % Test
  , "com.novocode" % "junit-interface" % "0.11" % Test
)

// publishing settings

Publish.settings(
  repo = Repository.github("malcolmgreaves", name.toString),
  developers =
    Seq(
      Dev("Tamir", "Hassan")
    ),
  art = ArtifactInfo.sonatype(semver),
  lic = License.apache20
)

// test settings
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
