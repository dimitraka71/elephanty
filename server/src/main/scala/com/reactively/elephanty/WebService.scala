package com.reactively.elephanty

import akka.http.scaladsl.server.Directives
import com.reactively.elephanty.shared.SharedMessages
import com.reactively.elephanty.twirl.Implicits._

class WebService() extends Directives {

  val route = {
    pathSingleSlash {
      get {
        complete {
          com.reactively.elephanty.html.index.render(SharedMessages.itWorks)
        }
      }
    } ~
      pathPrefix("assets" / Remaining) { file =>
        // optionally compresses the response with Gzip or Deflate
        // if the client accepts compressed responses
        encodeResponse {
          getFromResource("public/" + file)
        }
      }
  }
}
