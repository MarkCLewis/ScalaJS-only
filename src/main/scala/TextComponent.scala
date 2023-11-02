import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.scalajs.dom.experimental._
import slinky.core.facade.React

@react class TextComponent extends Component {
  case class Props(initialText: String)
  case class State(text: String, foo: Int, bar: Double)

  def initialState: State = State(props.initialText, 0, 0)

  def render() = {
    div (
      input (`type` := "text", value := state.text, 
        onChange := (e => setState(state.copy(text = e.target.value)))),
      br(),
      state.text
    )
  }
}