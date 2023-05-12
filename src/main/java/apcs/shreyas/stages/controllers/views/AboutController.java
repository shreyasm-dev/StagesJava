package apcs.shreyas.stages.controllers.views;

import apcs.shreyas.stages.Application;
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
    URL url = Application.class.getResource("about.html");
    webView.getEngine().load(url.toString());
  }
}
