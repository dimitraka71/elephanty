package com.reactively.elephanty

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives

class WebService() extends Directives {

  val route =
    get {
      (pathEndOrSingleSlash & redirectToTrailingSlashIfMissing(StatusCodes.TemporaryRedirect)) {
        getFromResource("web/index.html")
      } ~ {
        getFromResourceDirectory("web")
      }
    }
}
