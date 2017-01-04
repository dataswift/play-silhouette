package com.mohiva.play.silhouette.api

trait DynamicEnvironment {
  def id: String
}

case class DummyDynamicEnvironment() extends DynamicEnvironment {
  def id = "DummyDynamicEnvironment"
}
