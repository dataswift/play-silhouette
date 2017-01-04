package com.mohiva.play.silhouette.api

import java.security.interfaces.{ RSAPrivateKey, RSAPublicKey }

trait DynamicSecureEnvironment extends DynamicEnvironment {
  def id: String
  def privateKey: RSAPrivateKey
  def publicKey: RSAPublicKey
}
