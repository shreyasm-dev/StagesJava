package apcs.shreyas.stages.controllers.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
  @FXML
  private WebView webView;

  private final static String text = """
      $@text{Tsiolkovsky's rocket equation (also called the Ideal Rocket Equation) states that:}$
      
      $$@Delta v = v_e @ln{@frac{m_0}{m_f}}$$
      
      $@text{where:}$
      
      $$@begin{align*}
        @Delta v &= @text{change in velocity (m/s)}@@
        v_e &= @text{exhaust velocity (m/s)}@@
        m_0 &= @text{initial mass (kg)}@@
        m_f &= @text{final mass (kg)}
      @end{align*}$$
    """.replace('@', '\\'); // Use @ instead of \ to make it more readable (you need to escape the backslash, which makes it look messy)

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // This took way too long to get working
    this.webView.getEngine().loadContent("""
      <!DOCTYPE html>
      <html>
        <head>
          <link
            rel='stylesheet'
            href='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/katex.min.css'
            integrity='sha384-3UiQGuEI4TTMaFmGIZumfRPtfKQ3trwQE2JgosJxCnGmQpL/lJdjpcHkaaFwHlcI'
            crossorigin='anonymous'
          >
        </head>
        <body>
          <script
            defer
            src='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/katex.min.js'
            integrity='sha384-G0zcxDFp5LWZtDuRMnBkk3EphCK1lhEf4UEyEM693ka574TZGwo4IWwS6QLzM/2t'
            crossorigin='anonymous'
          ></script>
          <script
            defer
            src='https://cdn.jsdelivr.net/npm/katex@0.16.7/dist/contrib/auto-render.min.js'
            integrity='sha384-+VBxd3r6XgURycqtZ117nYw44OOcIax56Z4dCRWbxyPt0Koah1uHoK0o4+/RRE05'
            crossorigin='anonymous'
            onload='renderMathInElement(document.body, {delimiters: [{left: "$$", right: "$$", display: true}, {left: "$", right: "$", display: false}]});'
          ></script>
          """ + text + """
        </body>
       </html>
      """);
  }
}
