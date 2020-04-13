package com.reactively.elephanty

import akka.http.scaladsl.model.{ ContentTypes, HttpEntity }
import akka.http.scaladsl.server.Directives

class WebService() extends Directives {

  val route =
    path("client-fastopt.js")(getFromResource("client-fastopt.js")) ~
      get {
        (pathEndOrSingleSlash) {
          getFromResource("web/index.html")
        }
      } ~
      path("submit") {
        post {
          formFieldMap { fields =>
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>Say hello to for email: ${fields.toString()} </h1>"))
          }
        }
      } ~
      getFromResourceDirectory("web")
}
