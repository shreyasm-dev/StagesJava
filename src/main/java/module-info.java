module apcs.shreyas.stages {
  requires javafx.controls;
  requires javafx.fxml;

  requires net.synedra.validatorfx;
  requires com.dlsc.formsfx;

  opens apcs.shreyas.stages to javafx.fxml;
  exports apcs.shreyas.stages;
}
