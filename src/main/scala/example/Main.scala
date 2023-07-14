package example

import be.doeraene.webcomponents.ui5.Input
import be.doeraene.webcomponents.ui5.configkeys.ValueState
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom

@main
def helloWorld(): Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    // ButtonAppElement.appElement()
    myDiv
  )

def myDiv =
  div(
    Input(
      _.required    := true,
      _.valueState  := ValueState.Information,
      _.placeholder := "Enter your name",
      onChange.mapToValue --> Observer(println)
    )
  )
