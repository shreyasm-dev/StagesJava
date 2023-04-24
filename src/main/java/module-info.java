module apcs.shreyas.stages {
  requires javafx.controls;
  requires javafx.fxml;

  requires net.synedra.validatorfx;

  opens apcs.shreyas.stages to javafx.fxml;
  exports apcs.shreyas.stages;
  exports apcs.shreyas.stages.controllers.views;
  opens apcs.shreyas.stages.controllers.views to javafx.fxml;
}
