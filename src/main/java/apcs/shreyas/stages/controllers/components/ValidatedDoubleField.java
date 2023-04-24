package apcs.shreyas.stages.controllers.components;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

public class ValidatedDoubleField extends VBox {
  private Label label;
  private TextField field;
  private Validator validator;
  private double min = 0;
  private boolean minInclusive = false;

  public ValidatedDoubleField(String label, String value, Validator validator) {
    this.setSpacing(5);

    this.label = new Label(label);
    this.field = new TextField(value);
    this.validator = validator;

    this.field.setId(label);

    this.getChildren().addAll(this.label, this.field);

    this.validator.createCheck().dependsOn(label, this.field.textProperty()).withMethod(c -> {
      try {
        double val = Double.parseDouble(c.get(label));
        if ((this.minInclusive && val < this.min) || (!this.minInclusive && val <= this.min)) {
          c.error("Must be greater than " + (this.minInclusive ? "or equal to " : "") + this.min);
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(field).immediate();
  }

  public ValidatedDoubleField(String label, String value, Validator validator, double min, boolean minInclusive) {
    this(label, value, validator);
    this.min = min;
    this.minInclusive = minInclusive;
  }

  public String getText() {
    return this.field.getText();
  }

  public StringProperty textProperty() {
    return this.field.textProperty();
  }
}
