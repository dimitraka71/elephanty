package com.reactively.elephanty

import akka.http.scaladsl.server.Directives
//import com.reactively.elephanty.shared.SharedMessages

class WebService() extends Directives {

  val route = {
    pathSingleSlash {
      get {
        getFromResource("web/index2.html")
        //        complete {
        //          com.reactively.elephanty.html.index.render(SharedMessages.itWorks)
        //        }
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
