package example

import be.doeraene.webcomponents.ui5.configkeys.{
  BarDesign,
  ButtonDesign,
  IconName,
  TitleLevel,
  ValueState
}
import be.doeraene.webcomponents.ui5.*
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom

@main
def helloWorld(): Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    myDiv
  )

def myDiv =
  div(
    headerTag(
      myHeaderBar
    ),
    anInput,
    div("Some text"),
    myFooterBar
  )

def myHeaderBar =
  Bar(
    Title(
      "TipsLadder.com",
      _.level := TitleLevel.H2
    ),
    // _ => "TipsLadder.com",
    _.design := BarDesign.Header,
    _.slots.startContent := Button(
      _.icon    := IconName.home,
      _.tooltip := "Go home",
      _.design  := ButtonDesign.Transparent
    ),
    _.slots.endContent := Button(
      _.icon    := IconName.document,
      _.tooltip := "Doc",
      _.design  := ButtonDesign.Transparent
    )
  )

def anInput =
  Input(
    _.required    := true,
    _.valueState  := ValueState.Information,
    _.placeholder := "Enter your name",
    onChange.mapToValue --> Observer(println)
  )

def myFooterBar =
  Bar(
    _.design := BarDesign.Footer,
    // Note: this cal also just be Link...)
    _ =>
      Link(
        "Terms and Conditions",
        href   := "/static/TermsAndConditions.html",
        target := "_blank"
      )
  )
