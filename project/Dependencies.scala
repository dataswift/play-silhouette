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
import sbt._

object Dependencies {

  object LocalThirdParty {
    val specs2MatcherExtra   = "org.specs2"          %% "specs2-matcher-extra"    % "4.12.3"
    val casClient            = "org.jasig.cas.client" % "cas-client-core"         % "3.4.1"
    val casClientSupportSAML = "org.jasig.cas.client" % "cas-client-support-saml" % "3.4.1"
    val akkaTestkit          = "com.typesafe.akka"   %% "akka-testkit"            % "2.6.14"
  }

}
