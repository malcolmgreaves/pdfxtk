// use sbt-dev-settings to configure

import com.nitro.build._

import PublishHelpers._

// GAV

lazy val pName = "pdfXtk"

lazy val semver = SemanticVersion(0, 10, 0, isSnapshot = false)

organization := "io.malcolmgreaves"

name := pName

version := semver.toString

// compile & runtime

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.11.7", "2.10.5")

lazy val javaVersion = "1.7"

javacOptions in (Compile, compile) ++= Seq("-source", javaVersion, "-target", javaVersion) 

javacOptions in (doc) ++= Seq("-source", javaVersion) 

// dependencies and their resolvers

resolvers := Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
  ,"Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
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
  , "xerces" % "xerces" % "2.4.0"
  // testing
  , "junit" % "junit" % "4.11" % Test
  , "com.novocode" % "junit-interface" % "0.11" % Test
)

// publishing settings

Publish.settings(
  repo = Repository.github("malcolmgreaves", pName),
  developers =
    Seq(
      Developer("tamirhassan", "Tamir Hassan", "dev@tamirhassan.com", new URL("http", "github.com", "/tamirhassan") )
    ),
  art = ArtifactInfo.sonatype(semver),
  lic = License.apache20
)

// test settings
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
