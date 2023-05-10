package apcs.shreyas.stages.controllers.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
  @FXML
  private WebView webView;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // This took way too long to get working
    webView.getEngine().loadContent("""
        <script>
        MathJax = {
          tex: {
            inlineMath: [['$', '$'], ['$$', '$$']],
          },
          svg: {
            fontCache: 'global'
          }
        };
        </script>
        <script type="text/javascript" id="MathJax-script" async
          src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-svg.js">
        </script>
        <p>Example: $\\frac{1}{2}$</p>
      """);
  }
}
