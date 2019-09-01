package com.reactively.elephanty

import org.scalajs.dom
import org.scalajs.dom.raw.{ HTMLButtonElement, _ }

import scala.scalajs.js

object ScalaJSExample extends js.JSApp {
  val joinButton = dom.document.getElementById("join").asInstanceOf[HTMLButtonElement]
  val sendButton = dom.document.getElementById("send").asInstanceOf[HTMLButtonElement]

  def main(): Unit = {
    val nameField = dom.document.getElementById("name").asInstanceOf[HTMLInputElement]
    joinButton.onclick = { (onEvent: MouseEvent) =>
      joinButton.disabled = true
      val playground = dom.document.getElementById("scalajsShoutOut")
      playground.innerHTML = s"Trying to join chat as '${nameField.value}'..."
      onEvent.preventDefault()
    }
  }
}
