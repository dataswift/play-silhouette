package com.mohiva.play.silhouette.api.services

import com.mohiva.play.silhouette.api.DynamicEnvironment
import play.api.mvc.Request
import scala.concurrent.Future

trait DynamicEnvironmentProviderService[D <: DynamicEnvironment] {

  /**
    * Retrieves dynamic environment details according to request information
    *
    * @param request The request for which to retrieve the dynamic environment
    * @return Optional DynamicEnvironment - None if no such environment has been found
    */
  def retrieve[B](request: Request[B]): Future[Option[D]]
}
