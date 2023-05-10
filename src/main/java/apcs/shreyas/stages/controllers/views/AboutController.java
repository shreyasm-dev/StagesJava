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
        <!DOCTYPE html>
        <html>
          <head>
            <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/katex.min.css' integrity='sha384-3UiQGuEI4TTMaFmGIZumfRPtfKQ3trwQE2JgosJxCnGmQpL/lJdjpcHkaaFwHlcI' crossorigin='anonymous'>
          </head>
          <body>
            <script defer src='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/katex.min.js' integrity='sha384-G0zcxDFp5LWZtDuRMnBkk3EphCK1lhEf4UEyEM693ka574TZGwo4IWwS6QLzM/2t' crossorigin='anonymous'></script>
            <script defer src='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/contrib/auto-render.min.js' integrity='sha384-+VBxd3r6XgURycqtZ117nYw44OOcIax56Z4dCRWbxyPt0Koah1uHoK0o4+/RRE05' crossorigin='anonymous'
                onload='renderMathInElement(document.body);'></script>
            <div>
              Example KaTeX: \\(\\frac{1}{n^{2}}\\sum_{i=1}^{n}i\\)
            </div>
          </body>
        </html>
      """);
  }
}
