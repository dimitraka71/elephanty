package com.reactively.elephanty

import com.reactively.elephanty.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.raw.{ HTMLButtonElement, _ }
import org.scalajs.dom.ext.Ajax

import scala.scalajs.js

object ScalaJSExample extends js.JSApp {

  val formm = dom.document.getElementById("profile").asInstanceOf[HTMLFormElement]

  def main(): Unit = {
    formm.onsubmit = { (event: Event) =>
      val formData = new FormData(dom.document.getElementById("profile").asInstanceOf[HTMLFormElement])

      event.preventDefault()
    }
  }

  //  val joinButton = dom.document.getElementById("join").asInstanceOf[HTMLButtonElement]
  //  val sendButton = dom.document.getElementById("send").asInstanceOf[HTMLButtonElement]
  //
  //  def main(): Unit = {
  //    val nameField = dom.document.getElementById("name").asInstanceOf[HTMLInputElement]
  //
  //    sendButton.onclick = { (event: MouseEvent) =>
  //      val playground = dom.document.getElementById("playground")
  //      playground.innerHTML = s"Trying to join chat..."
  //
  //      val chat = new WebSocket(getWebsocketUri(dom.document, nameField.value))
  //
  //      chat.onopen = { (event: Event) =>
  //        playground.insertBefore(p("Chat connection was successful!"), playground.firstChild)
  //        event
  //      }
  //      event.preventDefault()
  //    }
  //  }

  //  val formm = dom.document.getElementById("formm").asInstanceOf[HTMLFormElement]
  //
  //  def main(): Unit = {
  //    formm.onsubmit = { (event: Event) =>
  //      val formData = new FormData(dom.document.getElementById("formm").asInstanceOf[HTMLFormElement])
  //      //
  //      val playground = dom.document.getElementById("playground")
  //      playground.innerHTML = s"Trying to join chat..."
  //      //
  //      val chat = new WebSocket(getWebsocketUri(dom.document, formData.toString))
  //
  //      chat.onopen = { (event: Event) =>
  //        playground.insertBefore(p("Chat connection was successful!"), playground.firstChild)
  //        event
  //      }
  //      event.preventDefault()
  //    }
  //  }

  //  def getWebsocketUri(document: Document, nameOfChatParticipant: String): String = {
  //    val wsProtocol = if (dom.document.location.protocol == "https:") "wss" else "ws"
  //
  //    s"$wsProtocol://${dom.document.location.host}/form?name=$nameOfChatParticipant"
  //  }
  //
  //  def p(msg: String) = {
  //    val paragraph = dom.document.createElement("p")
  //    paragraph.innerHTML = msg
  //    paragraph
  //  }

  //  val joinButton = dom.document.getElementById("join").asInstanceOf[HTMLButtonElement]
  //  val sendButton = dom.document.getElementById("send").asInstanceOf[HTMLButtonElement]
  //
  //  def main(): Unit = {
  //    val nameField = dom.document.getElementById("name").asInstanceOf[HTMLInputElement]
  //    joinButton.onclick = { (onEvent: MouseEvent) =>
  //      joinButton.disabled = true
  //      val playground = dom.document.getElementById("scalajsShoutOut")
  //      playground.innerHTML = s"Trying to join chat as '${nameField.value}'..."
  //      onEvent.preventDefault()
  //    }
  //  }
}
