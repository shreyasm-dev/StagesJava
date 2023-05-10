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
    webView.getEngine().loadContent("is it finally working? maybe, maybe not");
  }
}
