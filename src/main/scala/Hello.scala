import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html

import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._


object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello World.")
    println("Make sure Lewis isn't lying.")
    println("Lewis isn't lying...much.")

    document.getElementById("title").innerHTML = "Scala.js"
    document.getElementById("content").innerHTML =
      "No more dealing with straight JavaScript!"
    document.getElementById("inclass").innerHTML = "More text"
    appendPar(document.body, "Hello World")

    drawSomethingOnCanvas(document.getElementById("canvas").asInstanceOf[html.Canvas])

    ReactDOM.render(
      div(h1("Hi!"), TextComponent("Stuff")),
      document.getElementById("react-root")
    )
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def drawSomethingOnCanvas(canvas: html.Canvas): Unit = {
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.fillRect(100, 100, 100, 100)
  }
}