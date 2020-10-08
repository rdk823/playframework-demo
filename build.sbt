lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    name := """api""",
    version := "1.0.0",
    scalaVersion := "2.12.11",
    libraryDependencies ++= Seq(
      guice,
      filters,
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
      "commons-codec" % "commons-codec" % "1.15",
      specs2 % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      //      "-deprecation",
      "-Xfatal-warnings"
    )
  )

dockerBaseImage := "openjdk:8"

javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

dockerExposedVolumes := Seq("/opt/docker/logs")
