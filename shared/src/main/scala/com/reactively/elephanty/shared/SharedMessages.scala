package com.reactively.elephanty.shared

import play.api.libs.json.{ Format, Json }

case class Series(id: String, title: String)

trait JsonSupport {
  implicit val format: Format[Series] = Json.format
}

object SharedMessages {
  def itWorks = "It works!"
}
