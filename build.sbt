/**
  * Copyright 2015 Mohiva Organisation (license at mohiva dot com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
import Dependencies.Library

val publishSettings = {
  publishTo := {
    val prefix = if (isSnapshot.value) "snapshots" else "releases"
    Some(prefix at s"s3://library-artifacts-$prefix.hubofallthings.com")
  }
}

lazy val silhouette = Project(
  id = "dataswift-play-silhouette",
  base = file("silhouette")
).settings(
  publishSettings,
  libraryDependencies ++= Seq(
        Library.commonsLang3,
        Library.Play.cache,
        Library.Play.ws,
        Library.Play.openid,
        Library.Play.jsonJoda,
        Library.jwtCore,
        Library.jwtApi,
        Library.Play.specs2        % Test,
        Library.specs2MatcherExtra % Test,
        Library.scalaGuice         % Test,
        Library.akkaTestkit        % Test
      )
).enablePlugins(PlayScala)

lazy val silhouetteCas = Project(
  id = "dataswift-play-silhouette-cas",
  base = file("silhouette-cas")
).settings(publishSettings,
           libraryDependencies ++= Seq(
                 Library.casClient,
                 Library.casClientSupportSAML
               )
).dependsOn(silhouette % "compile->compile;test->test")

lazy val silhouetteCryptoJca = Project(
  id = "dataswift-play-silhouette-crypto-jca",
  base = file("silhouette-crypto-jca")
).settings(publishSettings)
  .dependsOn(silhouette % "compile->compile;test->test")

lazy val silhouettePasswordBcrypt = Project(
  id = "dataswift-play-silhouette-password-bcrypt",
  base = file("silhouette-password-bcrypt")
).settings(publishSettings, libraryDependencies += Library.jbcrypt)
  .dependsOn(silhouette % "compile->compile;test->test")

lazy val silhouettePersistence = Project(
  id = "dataswift-play-silhouette-persistence",
  base = file("silhouette-persistence")
).settings(publishSettings)
  .dependsOn(silhouette % "compile->compile;test->test")

lazy val silhouetteTestkit = Project(
  id = "dataswift-play-silhouette-testkit",
  base = file("silhouette-testkit")
).settings(publishSettings, libraryDependencies += Library.Play.test)
  .dependsOn(silhouette % "compile->compile;test->test")
  .enablePlugins(PlayScala)

val root = Project("play-silhouette-root", file("."))
  .aggregate(
    silhouette,
    silhouetteCas,
    silhouetteCryptoJca,
    silhouettePasswordBcrypt,
    silhouettePersistence,
    silhouetteTestkit
  )

inThisBuild(
  List(
    scalaVersion := "2.13.5",
    scalafixScalaBinaryVersion := "2.13",
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    organization := "com.mohiva",
    resolvers += "Atlassian Releases" at "https://maven.atlassian.com/public/",
    parallelExecution in Test := false,
    fork in Test := true,
    // Needed to avoid https://github.com/travis-ci/travis-ci/issues/3775 in forked tests
    // in Travis with `sudo: false`.
    // See https://github.com/sbt/sbt/issues/653
    // and https://github.com/travis-ci/travis-ci/issues/3775
    javaOptions += "-Xmx1G"
  )
)
