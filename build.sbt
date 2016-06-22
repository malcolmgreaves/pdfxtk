// use sbt-dev-settings to configure
import com.nitro.build._
import PublishHelpers._

// GAV
//
lazy val pName  = "pdfXtk"
lazy val semver = SemanticVersion(0, 10, 4, isSnapshot = false)
organization   := "io.malcolmgreaves"
name           := pName
version        := semver.toString

// compile & runtime
//
scalaVersion       := "2.11.7"
crossScalaVersions := Seq("2.11.7", "2.10.5")

lazy val javaVersion                 = "1.7"
javacOptions in (Compile, compile) ++= Seq("-source", javaVersion, "-target", javaVersion) 
javacOptions in (doc)              ++= Seq("-source", javaVersion) 

// dependencies and their resolvers
//
lazy val pdfboxV = "1.8.12"
libraryDependencies ++= Seq(
  "commons-collections" % "commons-collections" % "3.1"
  , "commons-lang" % "commons-lang" % "2.4"
  , "commons-io" % "commons-io" % "2.4"
  , "xstream" % "xstream" % "1.2.2"
  , "org.apache.pdfbox" % "pdfbox" % pdfboxV
  , "org.apache.pdfbox" % "fontbox" % pdfboxV
  , "org.apache.pdfbox" % "pdfbox-app" % pdfboxV
  , "xerces" % "xerces" % "2.4.0"
  // testing
  , "junit" % "junit" % "4.11" % Test
  , "com.novocode" % "junit-interface" % "0.11" % Test
)
resolvers := Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
  ,"Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

// publishing settings
//
Publish.settings(
  repo = Repository.github("malcolmgreaves", pName),
  developers =
    Seq(
      Dev.github("tamirhassan",    "Tamir Hassan",        "dev@tamirhassan.com"),
      Developer("???",             "Gervase Gallant",     "gervasegallant@yahoo.com", new URL("https", "www.linkedin.com", "/pub/gervase-gallant/0/986/69")),
      Dev.github("sagnik",         "Sagnik Ray Choudhury", ""),
      Dev.github("malcolmgreaves", "Malcolm Greaves",     "greaves.malcolm@gmail.com")
    ),
  art = ArtifactInfo.sonatype(semver),
  lic = License.apache20
)

// test settings
//
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
