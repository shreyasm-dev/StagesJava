package apcs.shreyas.stages.controllers.views;

import apcs.shreyas.stages.Utility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
  @FXML
  private WebView webView;

  private final static String text =
    Utility.Tex.text("Tsiolkovsky's rocket equation (also called the Ideal Rocket Equation) states that:") +
      Utility.Tex.displayMath(Utility.Tex.delta() + "v=" +
        Utility.Tex.sub("v", "e") +
        Utility.Tex.ln(
          Utility.Tex.fraction(
            Utility.Tex.sub("m", "0"),
            Utility.Tex.sub("m", "f")
          )
        )
      ) +
      Utility.Tex.text("where:") +
      Utility.Tex.displayMath(
        Utility.Tex.list(
          Utility.Tex.delta() + "v=" + Utility.Tex.embeddedText("change in velocity (") + Utility.Tex.fraction("m", "s") + Utility.Tex.embeddedText(")"),
          Utility.Tex.sub("v", "e") + "=" + Utility.Tex.embeddedText("exhaust velocity (") + Utility.Tex.fraction("m", "s") + Utility.Tex.embeddedText(")"),
          Utility.Tex.sub("m", "0") + "=" + Utility.Tex.embeddedText("initial mass (") + "kg" + Utility.Tex.embeddedText(")"),
          Utility.Tex.sub("m", "f") + "=" + Utility.Tex.embeddedText("final mass (") + "kg" + Utility.Tex.embeddedText(")")
        )
      ) +
      Utility.Tex.math("v_e") + Utility.Tex.text(" is the effective exhaust velocity, which is the speed of the rocket's exhaust as it leaves the rocket. It is calculated with the following equation:") +
      Utility.Tex.displayMath("v_e=" +
        Utility.Tex.sub("g", "0") +
        Utility.Tex.sub("I", "sp")
      ) +
      Utility.Tex.text("where:") +
      Utility.Tex.displayMath(
        Utility.Tex.list(
          Utility.Tex.sub("g", "0") + "=" + Utility.Tex.embeddedText("standard gravity (constant, approximately 9.81) (") + Utility.Tex.fraction("m", "s^2") + Utility.Tex.embeddedText(")"),
          Utility.Tex.sub("I", "sp") + "=" + Utility.Tex.embeddedText("specific impulse (") + Utility.Tex.fraction("s", "s") + Utility.Tex.embeddedText(")")
        )
      ) +
      Utility.Tex.math("I_{sp}") +
      Utility.Tex.text(" is the specific impulse, which is a measure of the efficiency of the rocket's engine. It's more convenient to use this value than the raw exhaust velocity (even though it has nothing to do with impulse in physics).");

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // This took way too long to get working
    this.webView.getEngine().loadContent("<script async src='https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-svg.js'></script>" + text);
  }
}
