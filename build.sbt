import sbtcrossproject.{crossProject, CrossType}

lazy val commonSettings = Seq(
  scalaVersion := "2.12.5",
  organization := "com.reactively",
  scalacOptions ++= Seq("-deprecation", "-feature", "-encoding", "utf8", "-Ywarn-dead-code", "-unchecked", "-Xlint", "-Ywarn-unused-import")
) ++ ScalariformSupport.formatSettings

lazy val server = (project in file("server"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.1",
      "com.typesafe.akka" %% "akka-stream" % "2.5.11"
    ),
    resourceGenerators in Compile += Def.task {
      val f1 = (fastOptJS in Compile in client).value
      val f2 = (packageScalaJSLauncher in Compile in client).value
      Seq(f1.data, f2.data)
    }.taskValue,
    watchSources ++= (watchSources in client).value
  ).dependsOn(sharedJvm)

lazy val client = (project in file("client"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings).settings(
  scalaJSUseMainModuleInitializer := true,
  testFrameworks += new TestFramework("utest.runner.Framework"),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.5",
    "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3"
  )
).dependsOn(sharedJs)

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("shared"))
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-json" % "2.6.0"
  ))

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

