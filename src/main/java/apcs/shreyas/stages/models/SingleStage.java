package apcs.shreyas.stages.models;

public class SingleStage extends Rocket {
  private Stage stage;

  public SingleStage(Stage stage, double payloadMass) {
    this.stage = stage;
    this.payloadMass = payloadMass;
  }

  public Stage getStage() {
    return this.stage;
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  // Calculated values

  public double getInitialMass() {
    return this.stage.getInitialMass() + this.payloadMass;
  }

  public double getFinalMass() {
    return this.stage.getFinalMass() + this.payloadMass;
  }

  public double getDeltaV() {
    return this.stage.getExhaustVelocity() * Math.log(this.getInitialMass() / this.getFinalMass());
  }
}
