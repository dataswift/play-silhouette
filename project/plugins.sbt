resolvers += "HAT Library Artifacts releases" at "https://s3-eu-west-1.amazonaws.com/library-artifacts-releases.hubofallthings.com"
addSbtPlugin("com.typesafe.play"  % "sbt-plugin"            % "2.8.8")
addSbtPlugin("com.frugalmechanic" % "fm-sbt-s3-resolver"    % "0.19.0")
addSbtPlugin("io.dataswift"       % "sbt-scalatools-common" % "0.2.3")
addSbtPlugin("org.scalameta"      % "sbt-scalafmt"          % "2.4.2")
addSbtPlugin("ch.epfl.scala"      % "sbt-scalafix"          % "0.9.26")
addSbtPlugin("com.dwijnand"       % "sbt-dynver"            % "4.1.1")
